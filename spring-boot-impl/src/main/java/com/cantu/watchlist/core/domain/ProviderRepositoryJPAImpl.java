package com.cantu.watchlist.core.domain;

import com.cantu.watchlist.core.domain.mapper.FromProviderMapper;
import com.cantu.watchlist.core.domain.mapper.ToMovieMapper;
import com.cantu.watchlist.core.domain.mapper.ToProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ProviderRepositoryJPAImpl implements ProviderRepository {

    @Autowired
    private ProviderRepositoryJPA jpaRepository;

    @Override
    public void save(Provider provider) {
        jpaRepository.save(
                new FromProviderMapper()
                        .apply(provider)
        );
    }

    @Override
    public Provider findById(EntityId id) {
        return new ToProviderMapper()
                .apply(
                        jpaRepository.findById((String) id.get()).orElseThrow()
                );
    }

    @Override
    public List<Provider> findAll() {
        return StreamSupport.stream(
                jpaRepository
                        .findAll()
                        .spliterator(),
                false)
                .map(providerJPA -> new ToProviderMapper().apply(providerJPA))
                .collect(Collectors.toList());
    }
}
