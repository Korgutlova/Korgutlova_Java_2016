package com.korgutlova.dao;

import com.korgutlova.entities.News;

public interface NewsDao {
    News getNews(long id);

    boolean updateNews(News news);
}
