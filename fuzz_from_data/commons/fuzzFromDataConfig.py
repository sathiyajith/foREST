import os
from configparser import ConfigParser


def singleton(cls):
    """
    singleton implementation
    """
    _instance = {}

    def inner():
        """
        inner
        """
        if cls not in _instance:
            _instance[cls] = cls()
        return _instance[cls]

    return inner


@singleton
class FuzzFromDataConfig:
    """
    read configuration from config file
    """

    def __init__(self):
        config = ConfigParser(interpolation=None)
        path = os.path.join(os.path.abspath(os.path.dirname(__file__)), "../../restfultest_config.ini")
        print(f'loading configuration from path {path}...')
        config.read(path, encoding='UTF-8')
        self.cookie = str(config.get('fuzz_from_data', 'cookie'))
        self.log_path = str(config.get('fuzz_from_data', 'log_path'))
        self.base_url = str(config.get('fuzz_from_data', 'base_url'))
        self.json_drop_mutation_probability = float(
            config.get('fuzz_from_data', 'json_drop_mutation_probability'))
        self.json_selection_mutation_probability = float(
            config.get('fuzz_from_data', 'json_selection_mutation_probability'))
        self.json_value_mutation_probability = float(
            config.get('fuzz_from_data', 'json_value_mutation_probability'))
        self.query_string_drop_mutation_probability = float(
            config.get('fuzz_from_data', 'query_string_drop_mutation_probability'))
        self.query_string_selection_mutation_probability = float(
            config.get('fuzz_from_data', 'query_string_selection_mutation_probability'))
        self.query_string_value_mutation_probability = float(
            config.get('fuzz_from_data', 'query_string_value_mutation_probability'))
        self.log_parser_name = str(config.get('fuzz_from_data', 'log_parser_name'))


FUZZ_FROM_DATA_CONFIG = FuzzFromDataConfig()  # type: FuzzFromDataConfig
