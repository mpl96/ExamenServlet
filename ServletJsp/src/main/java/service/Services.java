package service;

import java.util.List;

import model.*;
import repository.*;

public class Services {
	private Repository repository = new Repository();
	private RepositoryCountries repositoryCountries = new RepositoryCountries();
	private RepositoryLanguages repositoryLanguages = new RepositoryLanguages();
	
	public void insertNewLanguage(String newLanguage, String country) {
		repositoryLanguages.insertTableLanguages(newLanguage);
		repositoryCountries.insertTableCountries(country, newLanguage);
	}

	public void insertCountry(String language, String country) {
		repositoryCountries.insertTableCountries(country, language);
	}
	
	public void DeleteLanguage(String language) {
		repository.DeleteTable(language);
	}
	
	public List<Countries> listCountries() {
		return repositoryCountries.listCountries();
	}
	
	public List<Languages> listLanguages() {
		return repositoryLanguages.listLanguages();
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
}