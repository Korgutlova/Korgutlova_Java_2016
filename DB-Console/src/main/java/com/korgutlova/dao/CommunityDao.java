package com.korgutlova.dao;

import com.korgutlova.entities.Community;

public interface CommunityDao {
    Community getCommunity(long id);

    boolean updateCommunity(Community community);
}
