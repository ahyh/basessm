package com.yanhuan.yhssm.dynamo.factory;

import com.yanhuan.yhssm.dynamo.dao.PlaylistDao;
import com.yanhuan.yhssm.dynamo.pojo.Playlist;
import com.yanhuan.yhssm.dynamo.proxy.MethodDesc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DyConfig {

    private static final Map<Method, MethodDesc> METHOD_DESC_MAP = new HashMap<>();

    static {
        try {
            MethodDesc methodDesc = new MethodDesc();
            methodDesc.setClazz(Playlist.class);
            methodDesc.setPrimary(true);
            methodDesc.setHashKey("id");
            Method getMethod = PlaylistDao.class.getDeclaredMethod("getPlaylistById", String.class);
            METHOD_DESC_MAP.put(getMethod, methodDesc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MethodDesc get(Method mapperMethod) {
        return METHOD_DESC_MAP.get(mapperMethod);
    }
}
