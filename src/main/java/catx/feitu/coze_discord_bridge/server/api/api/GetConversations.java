package catx.feitu.coze_discord_bridge.server.api.api;

import catx.feitu.coze_discord_bridge.server.APIHandler;
import catx.feitu.coze_discord_bridge.server.HandleType;
import catx.feitu.coze_discord_bridge.server.ResponseType;
import com.alibaba.fastjson.JSONObject;

public class GetConversations implements APIHandler {

    @Override
    public ResponseType handle(HandleType Handle) {
        ResponseType Response = new ResponseType();
        JSONObject json = new JSONObject(true);
        try {
            Response.code = 200;
            json.put("code", 200);
            json.put("message", "获取对话列表成功");
            json.put("data", Handle.CozeGPT.data.conversations.conversations);
        } catch (Exception e) {
            Response.code = 502;
            json.put("code", 502);
            json.put("message", "获取对话列表失败");
            json.put("data", null);
        }
        Response.msg = json.toJSONString();
        return Response;
    }
}
