package com.genesisstudio.ernteweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genesisstudio.ernteweb.mapper.DetailContentMapper;
import com.genesisstudio.ernteweb.domain.DetailContent;
@Service
public class DetailContentService extends ServiceImpl<DetailContentMapper, DetailContent> {

    @Autowired
    private DetailContentMapper detailContentMapper;
    public List<DetailContent> getByProductId(Integer target) {
        QueryWrapper<DetailContent> wrapper = new QueryWrapper<DetailContent>().eq("product_id", target);
        return detailContentMapper.selectList(wrapper);
    }
}
