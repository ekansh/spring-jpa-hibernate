package com.example.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.AppConfig;
import com.example.entity.Image;
import com.example.entity.Media;
import com.example.entity.Video;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class MediaServiceTest extends TestCase
{
	@Autowired
	MediaService mediaService;
	public MediaServiceTest() {
	}

   @Test
    public void testInsertMedia(){
//    	Media m =  new Image();
//		m.setName("an image");
//		mediaService.add(m);
//		List<Media> listMedia = mediaService.listMedia();
//		for (Media media : listMedia) {
//			System.out.println("Media Name "+ media.getName());
//		}
    }
}