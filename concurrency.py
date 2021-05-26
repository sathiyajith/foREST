import time
from module.Coverage_get_tool import GetCoverage
from core.case_execution.parallelism import parallelism
import os.path
from configparser import ConfigParser
from multiprocessing import Process


def concurrency():
    begin = time.time()
    config = ConfigParser()
    path = os.path.join(os.path.abspath(os.path.dirname(__file__)), "./restfultest_config.ini")
    config.read(path, encoding='UTF-8')
    process_num = int(config.get("process_num", "process_num"))
    test_yaml = config.get('test_config', 'test_yaml')
    optional_params_execute_nums = int(config.get('test_config', 'optional_params_nums'))
    cov_url = config.get('coverage_config', 'cov_url')
    Authorization = config.get('Authorization', 'Authorization')
    fuzz_test_num = int(config.get('test_config', 'fuzz_test_times'))
    operation_mode = int(config.get('operation_mode', 'operation_mode'))
    experiment = int(config.get('experiment', 'experiment'))
    run_time = eval(config.get('run_time', 'run_time'))

    for i in range(process_num):
        p = Process(target=parallelism, args=(i, cov_url,optional_params_execute_nums,test_yaml,Authorization,
                                              fuzz_test_num,operation_mode, ))
        p.daemon = True
        p.start()
    if experiment == 1:
        coverage = "0.00"
        while float(''.join(list(coverage)[:-1])) <= 80.00:
            coverage = GetCoverage().getCoverage_rate_executed_code(cov_url)
        end = time.time()
        run_time = end - begin
        print("并发结束，当前覆盖率为: ", coverage,"  运行时间为 :", run_time)
    else:
        while time.time() - begin < float(run_time):
            time.sleep(10)
    coverage = GetCoverage().getCoverage_rate_executed_code(cov_url)
    print("并发结束，当前覆盖率为: ", coverage)

if __name__ == '__main__':
    concurrency()
