package com.example.myapp2.daos;

import com.example.myapp2.models.SocialMedia;
import com.example.myapp2.repositories.SocialMediaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMediaDao {
  @Autowired
  SocialMediaRepository socialMediaRepository;

  @GetMapping("/findAllSocialMedia")
  public Iterable<SocialMedia> findAllSocialMedias() {
    return socialMediaRepository.findAll();
  }
  @GetMapping("/findSocialMediaByArtist/{artistId}")
  public List<SocialMedia> findSocialMediaByArtist (
      @PathVariable("artistId") Integer artistId) {
    Iterable<SocialMedia> allSocialMedias = socialMediaRepository.findAll();
    List<SocialMedia> socialMedia = new ArrayList<SocialMedia>();
    for (SocialMedia current : allSocialMedias) {
      if (current.getArtistId() == artistId) {
        socialMedia.add(current);
      }
    }
    return socialMedia;
  }
}
