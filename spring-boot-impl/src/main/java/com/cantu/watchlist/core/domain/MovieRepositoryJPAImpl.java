package com.cantu.watchlist.core.domain;

import com.cantu.ddd.framework.domain.EntityId;
import com.cantu.watchlist.core.domain.mapper.FromMovieMapper;
import com.cantu.watchlist.core.domain.mapper.ToMovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MovieRepositoryJPAImpl implements MovieRepository {

    @Autowired
    private MovieRepositoryJPA jpaRepository;

    @Override
    public Movie save(Movie entity) {
        return new ToMovieMapper()
                .apply(
                        jpaRepository.save(
                                new FromMovieMapper()
                                        .apply(entity)
                        )
                );
    }

    @Override
    public Movie findById(EntityId id) {
        return new ToMovieMapper()
                .apply(
                        jpaRepository.findById((String) id.get()).orElseThrow()
                );
    }

    @Override
    public List<Movie> findAll() {
        return StreamSupport.stream(
                jpaRepository
                        .findAll()
                        .spliterator(),
                false)
                .map(movieJPA -> new ToMovieMapper().apply(movieJPA))
                .collect(Collectors.toList());
    }
}
