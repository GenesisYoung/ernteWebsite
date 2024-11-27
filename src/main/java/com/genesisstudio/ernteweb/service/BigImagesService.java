package com.genesisstudio.ernteweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genesisstudio.ernteweb.domain.BigImages;
import com.genesisstudio.ernteweb.mapper.BigImagesMapper;
@Service
public class BigImagesService extends ServiceImpl<BigImagesMapper, BigImages> {

    @Autowired
    private BigImagesMapper bigImagesMapper;
    public List<BigImages> getByProductId(Integer target) {
        QueryWrapper<BigImages> wrapper = new QueryWrapper<BigImages>().eq("product_id", target);
        return bigImagesMapper.selectList(wrapper);
    }
}
