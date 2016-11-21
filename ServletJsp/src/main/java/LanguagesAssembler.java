import javax.servlet.http.HttpServletRequest;

import org.h2.util.StringUtils;

public class LanguagesAssembler {

	public static Languages assembleLanguagesFrom(HttpServletRequest req) {
		Languages languages = new Languages();
		String Language = req.getParameter("language");
		
		if (!StringUtils.isNullOrEmpty(Language))
			languages.setLanguage(Language);
		
		return languages;
	}
}
