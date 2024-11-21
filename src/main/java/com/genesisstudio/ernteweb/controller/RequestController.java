package com.genesisstudio.ernteweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.genesisstudio.ernteweb.config.Response;
import com.genesisstudio.ernteweb.config.Util;
import com.genesisstudio.ernteweb.domain.*;
import com.genesisstudio.ernteweb.service.*;
import com.genesisstudio.ernteweb.vo.*;
import com.genesisstudio.ernteweb.vo.News;
import com.genesisstudio.ernteweb.vo.Product;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("request")
public class RequestController {
    @Autowired
    private EventsService eventsService;
    @Autowired
    private HornorService hornorService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ManualsService manualsService;
    @Autowired
    private RecepiesService recepiesService;
    @Autowired
    private HomeImgService homeImgService;
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private ProductService productService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private OfflineSpotsService offlineSpotsService;
    @Autowired
    private BigImagesService bigImagesService;
    @Autowired
    private DetailContentService detailContentService;
    @RequestMapping("about")
    public Response about() {
        Response response = new Response();
        List<Events> events = eventsService.list();
        List<Hornor> horror = hornorService.list();
        List<Products> products = productsService.list();
        AboutVO aboutVO = new AboutVO();
        aboutVO.setEvents(events);
        String[] horrorString=new String[horror.size()];
        String[] productsString=new String[products.size()];
        for (int i = 0; i < horror.size(); i++) {
            horrorString[i]=horror.get(i).getHornor();
        }
        for (int i = 0; i < products.size(); i++) {
            productsString[i]=products.get(i).getProduct();
        }
        aboutVO.setHornors(horrorString);
        aboutVO.setProducts(productsString);
        response.setData(aboutVO);
        return response;
    }
    @RequestMapping("download")
    public Response download() {
        Response response = new Response();
        List<Manuals> manuals = manualsService.list();
        List<Recepies> recepies = recepiesService.list();
        DownloadVO downloadVO = new DownloadVO();
        downloadVO.setManuals(manuals);
        downloadVO.setRecipes(recepies);
        response.setData(downloadVO);
        return response;
    }
    @RequestMapping("home")
    public Response home() {
        Response response = new Response();
        HomeVO homeVO = new HomeVO();
        List<HomeImg> homeImgs = homeImgService.list();
        List<Series> series = seriesService.list();
        String[] imgString=new String[homeImgs.size()];
        String[] seriesString=new String[series.size()];

        for (int i = 0; i < homeImgs.size(); i++) {
            String imgId = homeImgs.get(i).getImgId();
            imgString[i]=Util.transToImgUrl(imgId);
        }
        for (int i = 0; i < series.size(); i++) {
            seriesString[i]=series.get(i).getSeriesName();
        }
        homeVO.setScreenImages(imgString);
        homeVO.setProductsSeries(seriesString);
        List<com.genesisstudio.ernteweb.domain.Product> products = productService.list();
        for (com.genesisstudio.ernteweb.domain.Product product : products) {
            product.setPath(Util.transToImgUrl(product.getImgId()));
            product.setSeries(seriesService.getById(product.getSeriesId()).getSeriesName());
        }
        homeVO.setProducts(products);
        List<com.genesisstudio.ernteweb.domain.News> news = newsService.list();
        ArrayList<News> newsVOs = new ArrayList<>();
        news.forEach(newsVO -> {
            News vo= new News();
            vo.setId(newsVO.getId());
            vo.setTitle(newsVO.getTitle());
            vo.setImgId(newsVO.getImgId());
            vo.setDescription(newsVO.getDescription());
            vo.setCategory(newsVO.getCategory());
            vo.setImgId(newsVO.getImgId());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(newsVO.getDate());
            vo.setDateYear(String.valueOf(calendar.get(Calendar.YEAR)));
            vo.setDateVO(String.valueOf(calendar.get(Calendar.MONTH) + 1));
            vo.setPath(Util.transToImgUrl(newsVO.getImgId()));
            newsVOs.add(vo);
        });
        homeVO.setNews(newsVOs);
        response.setData(homeVO);
        return response;
    }
    @RequestMapping("news")
    private Response news(Integer page,@RequestParam(required = false) String type) {
        Response response = new Response();
        Page<com.genesisstudio.ernteweb.domain.News> newsPage = new Page<>(page,5);
        QueryWrapper<com.genesisstudio.ernteweb.domain.News> newsQueryWrapper = new QueryWrapper<>();
        newsQueryWrapper.eq("category",type);
        List<com.genesisstudio.ernteweb.domain.News> newsList;
        if(type!=null&& !type.isEmpty()){
            newsList = newsService.list(newsPage,newsQueryWrapper);
        }else{
            newsList=newsService.list(newsPage);
        }
        List<News> vos = new ArrayList<>();
        for (com.genesisstudio.ernteweb.domain.News news : newsList) {
            News vo = getVo(news);
            vos.add(vo);
        }
        NewsVO vo = new NewsVO();
        vo.setNews(vos);
        vo.setTotal(newsPage.getTotal());
        response.setData(vo);
        return response;
    }

    private static News getVo(com.genesisstudio.ernteweb.domain.News news) {
        News vo = new News();
        vo.setId(news.getId());
        vo.setTitle(news.getTitle());
        vo.setCategory(news.getCategory());
        vo.setDescription(news.getDescription());
        Date date = news.getDate();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        vo.setDateYear(String.valueOf(instance.get(Calendar.YEAR)));
        vo.setDateVO(String.valueOf(instance.get(Calendar.MONTH)+1)+"-"+String.valueOf(instance.get(Calendar.DATE)));
        vo.setPath(Util.transToImgUrl(news.getImgId()));
        return vo;
    }

    @RequestMapping("offline")
    private Response offline() {
        Response response = new Response();
        List<OfflineSpots> list = offlineSpotsService.list();
        ArrayList<Offline> offlines = new ArrayList<>();
        for (OfflineSpots offlineSpots : list) {
            Offline offline = new Offline();
            offline.setId(offlineSpots.getId());
            offline.setEn(offlineSpots.getEn());
            offline.setCity(offlineSpots.getCity());
            String[] split = offlineSpots.getSpots().split(",");
            offline.setSpotsVO(split);
            offlines.add(offline);
        }
        OfflineVO offlineVO = new OfflineVO();
        offlineVO.setSpots(offlines);
        response.setData(offlineVO);
        return response;
    }
    @RequestMapping("detail")
    private Response detail(Integer target) {
        Response response = new Response();
        List<BigImages> bigImages=bigImagesService.getByProductId(target);
        List<DetailContent> detailContents=detailContentService.getByProductId(target);
        com.genesisstudio.ernteweb.domain.Product byId = productService.getById(target);
        Detail detail = new Detail();
        String[] bigImageString=new String[bigImages.size()];
        for (int i = 0; i < bigImages.size(); i++) {
            String imgId = bigImages.get(i).getImgId();
            String s = Util.transToImgUrl(imgId);
            bigImageString[i]=s;
        }
        detail.setBigImages(bigImageString);
        detail.setContents(detailContents);
        detail.setLeftImage(Util.transToImgUrl(byId.getLeftImgId()));
        detail.setId(byId.getId());
        detail.setTitle(byId.getTitle());
        detail.setDescription(byId.getDescription());
        detail.setColor(byId.getColor());
        detail.setArticle(byId.getArticle());
        detail.setTitleEn(byId.getTitleEn());
        detail.setArticleTitle(byId.getArticleTitle());
        detail.setDetailTitle(byId.getDetailTitle());
        detail.setArticle(byId.getArticle());
        String detailImageId = byId.getDetailImageId();
        String[] split = detailImageId.split(",");
        for (int i = 0; i < split.length; i++) {
            split[i]=Util.transToImgUrl(split[i].trim());
        }
        detail.setBigImages(split);
        DetailVO detailVO = new DetailVO();
        detailVO.setDetail(detail);
        response.setData(detailVO);
        return response;
    }
    @RequestMapping("products")
    private Response products() {
        Response response = new Response();
        List<com.genesisstudio.ernteweb.domain.Product> products = productService.list();
        List<Product> vos = new ArrayList<>();
        for (com.genesisstudio.ernteweb.domain.Product product : products) {
            Product productVO = new Product();
            productVO.setId(product.getId());
            productVO.setTitle(product.getTitle());
            productVO.setPath(Util.transToImgUrl(product.getImgId()));
            productVO.setSeries(seriesService.getById(product.getSeriesId()).getSeriesName());
            vos.add(productVO);
        }
        ProductVO productVO = new ProductVO();
        productVO.setProducts(vos);
        response.setData(productVO);
        return response;
    }
    @RequestMapping("news/detail")
    private Response newsDetail(Integer id) {
        Response response = new Response();
        com.genesisstudio.ernteweb.domain.News news = newsService.getById(id);
        response.setData(news.getContext());
        return response;
    }
}
