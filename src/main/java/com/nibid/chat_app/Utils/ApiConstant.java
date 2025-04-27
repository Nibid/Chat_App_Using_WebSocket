package com.nibid.chat_app.Utils;

public interface ApiConstant {

    String API = "/api";

    String FIND_ALL_USER = "/findAllUser";

    String REGISTER = "/register";
    String LOGIN = "/login";

    String USER = API + "/user";

    String MESSAGE = API + "/message";
    String SEND = "/send";

    // Websocket
    String TOPIC_MESSAGES = "/topic/messages";
    String VIEW_ALL_MESSAGES = "/viewAllMessages";

}
