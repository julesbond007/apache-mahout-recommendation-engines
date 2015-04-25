package com.jodisoft.recommendation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jodisoft.recommendation.model.Movie;
import com.jodisoft.recommendation.repository.MovieRepository;
import com.jodisoft.recommendation.service.MovieService;

/**
 * @author Jay Paulynice
 *
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;

    /**
     * @param repository the repository
     */
    @Autowired
    public MovieServiceImpl(final MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movie find(final Long id) {
        return repository.findOne(id);
    }
}