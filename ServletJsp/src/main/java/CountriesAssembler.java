import javax.servlet.http.HttpServletRequest;

import org.h2.util.StringUtils;

public class CountriesAssembler {

	public static Countries assembleCountriesFrom(HttpServletRequest req) {
		Countries countries = new Countries();
		String country = req.getParameter("country");
		String Language = req.getParameter("lsnguage");
		
		if (!StringUtils.isNullOrEmpty(country))
			countries.setCountry(country);
		
		if (!StringUtils.isNullOrEmpty(Language))
			countries.setLanguage(Language);
		
		return countries;
	}	
}
