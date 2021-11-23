package com.yanhuan.yhssm.dynamo.dao;

import com.yanhuan.yhssm.dynamo.annotations.DyIndexDesc;
import com.yanhuan.yhssm.dynamo.annotations.DyMapper;
import com.yanhuan.yhssm.dynamo.annotations.DyMethod;
import com.yanhuan.yhssm.dynamo.pojo.Playlist;

@DyMapper
public interface PlaylistDao {

    /**
     * 表示这个方法查zmcoeus
     */
    @DyMethod(
            value = "select * from zmcoeus_playlist where id = #{id}",
            table = "ZMCOEUS_PLAYLIST",
            index = @DyIndexDesc(primary = true, hashKey = "id")
    )
    Playlist getPlaylistById(String id);

}
