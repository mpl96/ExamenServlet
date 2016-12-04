package service;

import java.util.List;

import model.*;
import repository.*;

public class Services {
	private Repository repository = new Repository();
	
	public void insertNewLanguage(String nLanguage, String country) {
		repository.insertTableLanguages(nLanguage);
		repository.insertTableCountries(country, nLanguage);
	}

	public void insertCountry(String language, String country) {
		repository.insertTableCountries(country, language);
	}
	
	public void DeleteLanguage(String language) {
		repository.DeleteTable(language);
	}
	
	public List<Countries> listCountries() {
		return repository.listCountries();
	}
	
	public List<Languages> listLanguages() {
		return repository.listLanguages();
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
}