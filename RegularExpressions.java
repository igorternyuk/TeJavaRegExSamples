import java.util.regex.*;

public class RegularExpressions {
	private static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал.тайланд" +
	" мечты сбываются!";
	private static final String USER_NAME_PATTERN = "^[a-zA-Z0-9_-]{3,20}$";
	private static final String PHONE_NUMBER_PATTERN = "^\\+?\\(?[0-9]{3}\\)?((-| )?\\(?[0-9]{2,4}\\)?){0,4}$";
	private static final String EMAIL_ADDRESS__PATTERN = "^(\\w|\\.|-|%)+@[a-z]+\\.[A-Za-z]{2,4}$";
	private static final String LINK_PATTERN = "^(www\\.)?(\\w|\\.)+\\.(com|net|org|ru|ua|de|es|pt|br|uk|us|kz)$";
	private static final String IPADDRESS_PATTERN = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])(\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])){3}";

	public static boolean checkUserName(final String userName){
		return regexChecker(USER_NAME_PATTERN, userName);
	}

    public static boolean checkLink(final String link){
    	return regexChecker(LINK_PATTERN, link);
    }

    public static boolean checkPhoneNumber(final String phoneNumber){
    	return regexChecker(PHONE_NUMBER_PATTERN, phoneNumber);
    }

    public static boolean checkEmailAddress(final String email){
    	return regexChecker(EMAIL_ADDRESS__PATTERN, email);
    }

    public static boolean checkIpAddress(final String ip){
    	return regexChecker(IPADDRESS_PATTERN, ip);
    }

    private static boolean regexChecker(final String regex, final String strToCheck){
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(strToCheck);
    	return matcher.matches();
    }

    private static String regexReplace(final String input, final String regex, final String strToReplace){
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(input.trim());
    	return matcher.replaceAll(strToReplace);
    }

    private static void printAll(final String regex, final String strToCheck){
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(strToCheck);
    	while(matcher.find()){
    		if(matcher.group().length() == 0){
    			System.out.println(matcher.group().trim());
    		}
    		System.out.println("Start index = " + matcher.start());
    		System.out.println("End index = " + matcher.end());
    	}
    }

	public static void main(String[] args){
		String[] nicknames = { "Igor1990", "Lonely_she-woolf", "_vasya_84!", "Warfolomei80", "Wombat92" };
		for (final String nick: nicknames) {
			System.out.println(nick + " --> " + checkUserName(nick));	
		}

		String[] links = {"www.google.com", "ya ndex.ua", "www.rutracker.org", "kinozal.net", "ololo.su"};
		for (final String link: links) {
			System.out.println(link + " --> " + checkLink(link));	
		}

		System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд","Испания"));

		String[] emails = { "imisnet@ukr.net", "variato@ukr.net", "sovladf@mail.ru", "ololo@gmail.com",
		"ololo.ru", "zk.fm", "noa5@mail.ru", "irchik-luckik@yandex.ua", "mr.ternyuk@mail.ru",
		 "yasya_pupkin@ya.ru", "rulon-oboev@mail.kz" };

		for (final String email: emails) {
			System.out.println(email + " --> " + checkEmailAddress(email));	
		}

		String[] phones = { "+380-95-66-92-817", "380 95 66 92 817", "+(095)-66-92-819", "+(555)-123", "+095-(555)", "666", "(555)" };
		for (final String phone: phones) {
			System.out.println(phone + " --> " + checkPhoneNumber(phone));	
		}

		String[] ipAddresses = { "172.16.102.", "172.16.102.5", "192.168.42.72", "1254545454", "+095-(555)", "172.16.102.62", "(555)" };
		for (final String ip: ipAddresses) {
			System.out.println(ip + " --> " + checkIpAddress(ip));	
		}

		String input = "1  2 3   4   5";
		System.out.println(input);
		System.out.println(regexReplace(input, "\\s+", ", "));
	}
}