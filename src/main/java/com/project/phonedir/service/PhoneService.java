package com.project.phonedir.service;

import com.project.phonedir.model.Phone;
import com.project.phonedir.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    // Using JPA -> communicate | EntityManagerFactory -> EntityManger

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPosts(Integer userId) {
        return phoneRepository.getAllPosts( userId);
    }

    public void createPost(Phone newPost) {
        phoneRepository.createPost(newPost);
    }

    public void deletePost(Integer postId) {
        phoneRepository.deletePost(postId);
    }
}
