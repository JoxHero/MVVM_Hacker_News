package com.example.common;

/**
 * Created by Henry on 2015/10/26.
 */
public class Constants {
    public static final String PHONE_IP = "255.255.255.255";

    public static final String APPKEY_EXPLORE = "q!APPZLW#c0v";

    public static final String DEFAULT_IMAGE_CACHE = "images";
    public static final int DEFAULT_KLINE_COUNT = 200;

    public static final int DEFAULT_QR_WIDTH = 200;
    public static final int DEFAULT_QR_HEIGHT = 200;
    public static final int PROFILE_FOLLOW_SEARCH = 1;
    public static final int PROFILE_SPECTATOR_SEARCH = 2;
    public static final int SETTING_NO_LOOK_MY_SEARCH = 3;
    public static final int SETTING_NO_LOOK_HIS_SEARCH = 4;

    private Constants() {
    }

    public static final class Url {
        public static final String URL_SERVICE_TERM = "http://www.zlw.com/about/fw.asp";
        public static final String URL_RELIEF_TERM = "http://www.zlw.com/about/mz.asp";
        public static final String AVATAR = "http://www.zlw.com/api/avatar.asp?from=jyw&id=%s&size=normal";
        public static final String SEND_SMS_SERVICE = "http://api.app2e.com";
        public static final String SSO_SERVICE = "https://passport.zlw.com";
        public static final String UPLOAD_SERVICE = "http://www.zlw.com/";
        public static final String LOGIN_SERVICE = "http://loginservice.zlw.com:9999";
        public final static String SIM_STAT_SERVICE = "http://tradestat.zlw.com:8888";
        public final static String DYNAMIC_SERVICE = "http://jywfavortrade.zlw.com:8081";
        public static final String ACTIVITY_SERVICE = "http://chatservice.zlw.com:9998";
        public final static String ENGINE_SERVICE = "http://chatservice.zlw.com:9998";
        public static final String PHONE_SERVICE = "http://mjywsvc.zlw.com:8081";
        public final static String SIM_TRADE_SERVICE = "http://simtradesvc.zlw.com:8080";
        public final static String MARKET_SERVICE = "http://kline1.zlw.com:8080";


        //线上地址
        public static final String MQ_TRADE_BROKER_URL = "tcp://mq1.zlw.com:5673";
        public static final String MQ_MARKET_BROKER_URL = "tcp://mq1.zlw.com:5672";
        public static final String MATCH_MINE = "http://m.zlw.com/jyw/match";
        public static final String MATCH_FRIEND = "http://m.zlw.com/jyw/match/friends";
        public static final String MY_REWARD = "http://m.zlw.com/jyw/match/reward";//我的奖励
        public static final String URL_WEEK_MATCH_RANK = "http://m.zlw.com/jyw/match/cgs/weekrank";//周赛排行
        public static final String URL_MONTH_MATCH_RANK = "http://m.zlw.com/jyw/match/cgs/monthrank";//月赛排行
        public static final String URL_HONOR_RANK = "http://m.zlw.com/jyw/match/cgs/honor";//荣誉排行
        public static final String URL_MATCH_RULES = "http://m.zlw.com/jyw/match/cgs/rules";//比赛规则
        public static final String URL_GUIDE = "http://m.zlw.com/jyw/news/novice";
        public static final String URL_NEWS = "http://m.zlw.com/jyw/news/detail/";

        //线下地址
        /*public static final String MQ_TRADE_BROKER_URL = "tcp://192.168.1.188:61618";
        public static final String MQ_MARKET_BROKER_URL = "tcp://192.168.1.188:61223";
        public static final String MATCH_MINE = "http://192.168.1.109:8002/jyw/match";
        public static final String MATCH_FRIEND = "http://192.168.1.109:8002/jyw/match/friends";
        public static final String MY_REWARD = "http://192.168.1.109:8002/jyw/match/reward";//我的奖励
        public static final String URL_WEEK_MATCH_RANK = "http://192.168.1.109:8002/jyw/match/cgs/weekrank";
        public static final String URL_MONTH_MATCH_RANK = "http://192.168.1.109:8002/jyw/match/cgs/monthrank";
        public static final String URL_HONOR_RANK = "http://192.168.1.109:8002/jyw/match/cgs/honor";
        public static final String URL_MATCH_RULES = "http://192.168.1.109:8002/jyw/match/cgs/rules";
        public static final String URL_GUIDE = "http://192.168.1.109:8002/jyw/news/novice";
        public static final String URL_NEWS = "http://192.168.1.109:8002/jyw/news/detail/";*/
    }

    public static final class EndPoint {
        public static final String END_POINT_SEND_SMS_SERVICE = "http://api.app2e.com";
        public static final String END_POINT_YRATE_SERVICE = "http://jyw.zlw.com/";
        public final static String END_POINT_TRADE_SERVICE = "http://simtradesvc.zlw.com:8080";
        public final static String END_POINT_MARKET_SERVICE = "http://kline1.zlw.com:8080";
        //线上
        public static final String END_POINT_SSO_SERVICE = "https://passport.zlw.com";
        public static final String END_POINT_UPLOAD_SERVICE = "http://www.zlw.com/";
        public static final String END_POINT_LOGIN_SERVICE = "http://loginservice.zlw.com:9999";
        public final static String END_POINT_SIM_STAT_SERVICE = "http://tradestat.zlw.com:8888";
        public final static String END_POINT_DYNAMIC_SERVICE = "http://jywfavortrade.zlw.com:8081";
        public static final String END_POINT_ACTIVITY_SERVICE = "http://chatservice.zlw.com:9998";
        public final static String END_POINT_ENGINE_SERVICE = "http://chatservice.zlw.com:9998";
        public static final String END_POINT_PHONE_SERVICE = "http://mjywsvc.zlw.com:8081";
        //线下
        /*public static final String END_POINT_SSO_SERVICE = "http://192.168.1.109:8001";
        public static final String END_POINT_UPLOAD_SERVICE = "http://192.168.1.109:8003";
        public static final String END_POINT_LOGIN_SERVICE = "http://192.168.1.117:8888";
        public final static String END_POINT_SIM_STAT_SERVICE = "http://192.168.1.227:8080";
        public final static String END_POINT_DYNAMIC_SERVICE = "http://192.168.1.188:8888";
        public static final String END_POINT_ACTIVITY_SERVICE = "http://192.168.1.188:8888";
        public final static String END_POINT_ENGINE_SERVICE = "http://192.168.1.117:8888";
        public static final String END_POINT_PHONE_SERVICE = "http://192.168.1.187:8888";
        public final static String END_POINT_SIM_TRADE_SERVICE = "http://192.168.1.227:8888";*/
    }

    /*
    //线上地址
//#define HOST_REGISTERED_RENAME @"passport.zlw.com"
//#define URL_STRATE_ENG_SVC     @"http://chatservice.zlw.com:9998/axis2/services/StrategyEngine.StrategyEngineHttpSoap11Endpoint/"
//#define URL_DYNAMIC_SERVICE  @"http://jywfavortrade.zlw.com:8081/axis2/services/DynamicServices.DynamicServicesHttpSoap11Endpoint/"
//#define URL_SIM_STAT     @"http://tradestat.zlw.com:8888/axis2/services/SimStat.SimStatHttpSoap11Endpoint/"
//#define URL_PHONE_SERVICE  @"http://mjywsvc.zlw.com:8081/axis2/services/PhoneServices.PhoneServicesHttpSoap11Endpoint/"
//#define URL_ACTIVITY  @"http://chatservice.zlw.com:9998/axis2/services/Activity.ActivityHttpSoap11Endpoint/"
//#define URL_LOGIN  @"http://loginservice.zlw.com:9999/axis2/services/ZLBLogin.ZLBLoginHttpSoap11Endpoint/"
//线上地址

//内网地址
#define HOST_REGISTERED_RENAME @"192.168.1.109:8001"
#define URL_STRATE_ENG_SVC     @"http://192.168.1.117:8888/axis2/services/StrategyEngine.StrategyEngineHttpSoap11Endpoint/"
#define URL_DYNAMIC_SERVICE  @"http://192.168.1.188:8888/axis2/services/DynamicServices.DynamicServicesHttpSoap11Endpoint/"
#define URL_SIM_STAT     @"http://192.168.1.227:8080/axis2/services/SimStat.SimStatHttpSoap11Endpoint/"
#define URL_PHONE_SERVICE  @"http://192.168.1.187:8888/axis2/services/PhoneServices.PhoneServicesHttpSoap11Endpoint/"
#define URL_ACTIVITY  @"http://192.168.1.188:8888/axis2/services/Activity.ActivityHttpSoap11Endpoint/"
#define URL_LOGIN  @"http://192.168.1.117:8888/axis2/services/ZLBLogin.ZLBLoginHttpSoap11Endpoint/"
     */

    public static final class NameSpace {

        public static final String NAMESPACE_LOGIN = "http://webservices.login.common.zlb.com";
        public static final String NAMESPACE_TRADE = "http://webservices.trade.strategy.zlb.com";
        public static final String NAMESPACE_STAT = "http://webservices.stat.strategy.zlb.com";
        public static final String NAMESPACE_ACTIVITY = "http://webservices.activity.common.zlb.com";
        public final static String NAMESPACE_ENGINE = "http://webservices.engine.strategy.zlb.com";
        public static final String NAMESPACE_DYNAMIC = "http://webservices.dynamic.zlb.com";
        public static final String NAMESPACE_PHONE = "http://webservices.phone.zlb.com";
    }

    public static final class Argument {
        public static final String URL = "url";
        public static final String IID = "iid";
        public static final String UID = "uid";
        public static final String RID = "rid";
        public static final String GID = "gid";
        public static final String TAG = "tag";
        public static final String SELECTED_INSTRUMENT_INDEX = "selected_instrument_index";
        public static final String SELECTED_CHART_INDEX = "selected_chart_index";
        public static final String ORDERING_TYPE = "ordering_type";
        public static final String CO = "co";
        public static final String DIR = "dir";
        public static final String VOLUME = "volume";
        public static final String POSITION = "position";
        public static final String INTERVAL = "interval";
        public static final String ENABLE_OPERATE = "enable_operate";
        public static final String SEARCH_USER_ARGS = "args";
        public static final String SEARCH_USER_POSITION = "position";
        public static final String SEARCH_USER_ARGS_HOLD = "args_hold";
        public static final String FLAG = "flag";
        public static final String PROFILE_SEARCH_INDEX = "profile_search_index";
        public static final String FORGET_PWD_PHONE_NUM = "forget_pwd_phone_number";

        public static final String TYPE = "type";
        public static final String NICKNAME = "nickname";
        public static final String FOLLOWED = "followed";
        public static final String LABEL = "lable";

        private Argument() {
        }
    }

    public static final class FragmentTag {
        public static final String DIALOG_PROGRESS = "progress";
        public static final String DIALOG_DELETE_INSTRUMENT = "delete_instrument";
        public static final String DIALOG_REALIZE_FEE = "fealize_fee";
        public static final String DIALOG_HINT_MESSAGE = "hint_message";
        public static final String DIALOG_FOLLOW = "follow";
        public static final String DIALOG_DO_REALIZE_FEE = "do_fealize_fee";
        public static final String DIALOG_UPDATE_FEE = "update_fee";
        public static final String DIALOG_AUTH_PHONE = "auth_phone";
        public static final String PROFILE_ACCOUNT = "profile_account";
        public static final String PROFILE_SETTING_NOTIFY_TIME = "profile_setting_notify_time";

        public static final String SEARCH_USER_CITY_WIDE = "city_wide";
        public static final String SEARCH_USER_ALL = "all";
        public static final String SEARCH_USER_POPULAR_KING = "popular_king";
        public static final String SEARCH_USER_CHARGE = "charge";
        public static final String SEARCH_USER_TRADE_TIME = "trade_time";

        private FragmentTag() {
        }
    }

    public static final class Http {
        public static final int CONNECT_TIMEOUT = 10000;
        public static final int WRITE_TIMEOUT = 10000;
        public static final int READ_TIMEOUT = 30000;

        private Http() {
        }
    }

    public static final class RequestCode {
        public static final int REQUEST_PERMISSION = 1;
        public static final int WELCOME = 2;
        public static final int TO_LOGIN = 10;
        public static final int TO_REGISTER = 20;
        public static final int TO_REGISTER_TRADE_ROOM = 300;
        public static final int TO_WELCOME_TRADE_ROOM = 310;
        public static final int ADD_TRADE_INSTRUMENT = 320;
        public static final int ORDERING = 330;
        public static final int ORDERING_CLOSE_POSITION = 340;
        public static final int SEARCH_USER_FILTER = 410;
        public static final int TO_DATUM_PROFILE = 500;
        public static final int TO_SETTING_SEARCH = 600;
        public static final int VISIT_USER = 800;

        private RequestCode() {
        }
    }

    public static final class ResultCode {
        public static final int WELCOMED = 2;
        public static final int LOGIN_SUCCESS = 10;
        public static final int REGISTER_SUCCESS = 20;
        public static final int REGISTER_TRADE_ROOM_SUCCESS = 300;
        public static final int WELCOME_TRADE_ROOM_COMPLETE = 310;
        public static final int ADD_TRADE_INSTRUMENT_SUCCESS = 320;
        public static final int SEARCH_USER_FILTER = 410;
        public static final int UPDATE_AVATAR_SUCCESS = 500;
        public static final int ADD_BLACKLIST_USER_SECCESS = 510;

        private ResultCode() {
        }
    }

    public static final class OrderingType {
        public static final int NORMAL = 0;
        public static final int CLOSE_POSITION = -1;
    }

    public static final class Action {
        public static final int ORDERING = 1;
        public static final int CANCEL = 2;
        public static final int TRIGGER = 3;
    }

}
