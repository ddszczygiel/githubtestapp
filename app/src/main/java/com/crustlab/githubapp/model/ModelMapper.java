package com.crustlab.githubapp.model;

import com.crustlab.githubapp.model.remote.NewRepositoryEntity;
import com.crustlab.githubapp.model.remote.RepositoryEntity;

public class ModelMapper {

    private static final ModelMapper INSTANCE = new ModelMapper();

    public static ModelMapper getInstance() {
        return INSTANCE;
    }

    private ModelMapper() {}

    public Repository fromEntity(RepositoryEntity repositoryEntity) {
        return new Repository(repositoryEntity.getName(),
                repositoryEntity.getOwner().getLogin(),
                repositoryEntity.getUrl(),
                repositoryEntity.getCreatedAt());
    }

    public NewRepositoryEntity toEntity(Repository repository) {
        NewRepositoryEntity newRepositoryEntity = new NewRepositoryEntity();
        newRepositoryEntity.setName(repository.getName());
        return newRepositoryEntity;
    }
}
