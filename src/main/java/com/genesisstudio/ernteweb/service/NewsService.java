package com.genesisstudio.ernteweb.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genesisstudio.ernteweb.domain.News;
import com.genesisstudio.ernteweb.mapper.NewsMapper;
@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {

}
