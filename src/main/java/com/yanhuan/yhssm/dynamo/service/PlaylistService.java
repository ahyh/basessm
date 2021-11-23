package com.yanhuan.yhssm.dynamo.service;

import com.yanhuan.yhssm.dynamo.dao.PlaylistDao;
import com.yanhuan.yhssm.dynamo.pojo.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaylistService {

    @Autowired
    private PlaylistDao playlistDao;

    public Playlist getPlaylistById(String id){
        Playlist playlistById = playlistDao.getPlaylistById(id);
        System.out.println(playlistById);
        return playlistById;
    }
}
