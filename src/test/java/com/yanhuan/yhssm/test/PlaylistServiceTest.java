package com.yanhuan.yhssm.test;

import com.yanhuan.yhssm.dynamo.pojo.Playlist;
import com.yanhuan.yhssm.dynamo.service.PlaylistService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaylistServiceTest extends BaseTest {

    @Autowired
    private PlaylistService playlistService;

    @Test
    public void test(){
        Playlist playlistById = playlistService.getPlaylistById("11");
        System.out.println();
    }
}
