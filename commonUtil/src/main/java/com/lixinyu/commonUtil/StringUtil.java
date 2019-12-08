package com.lixinyu.commonUtil;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class StringUtil {
	/**
	 * @Title: isBlank   
	 * @Description: ÅĞ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ  
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isBlank(String str) {
		if(str==null) {
			return true;
		}
		//È¥¿Õ¸ñ
		str = str.trim();
		//
		if(str.length()==0) {
			return true;
		}
		return false;
	}
	/**
	 * @Title: isNotBlank   
	 * @Description: ×Ö·û´®ÄÚÈİ²»Îª¿Õ£¬·µ»Øtrue   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**
	 * @Title: isPhoneNum   
	 * @Description: ÅĞ¶Ï×Ö·û´®ÊÇ·ñÎªÊÖ»úºÅ   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}
	/**
	 * @Title: isEmail   
	 * @Description: ÑéÖ¤ÊÇ·ñÎªÓÊÏä   
	 * @param: @param str zhanggm1002@qq.com
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isEmail(String str) {
		String regex = "[A-Za-z0-9]+@[A-Za-z0-9]+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	/**
	 * @Title: isLetter   
	 * @Description: TODO(ÃèÊöÕâ¸ö·½·¨µÄ×÷ÓÃ)   
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isLetter(String str) {
		if(isNotBlank(str)) {
			str = str.toLowerCase();
			String regex = "[a-z]+";
			return str.matches(regex);
		}
		return false;
	}
	/**
	 * @Title: getRandomAzChar   
	 * @Description: »ñÈ¡Ëæ»ú×Ö·û£¨a-z£©   
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomAzChar() {
		//Ëæ»úÀà
		Random random = new Random();
		//¿ªÊ¼×Ö·ûÔÚacsiiÂë
		int startChar = 'a'+0;
		//Éú³ÉËæ»ú×Ö·û
		char newChar = (char)(startChar+random.nextInt(26));
		return newChar;
	}
	/**
	 * @Title: getRandomLetter   
	 * @Description: »ñÈ¡Ëæ»ú×Ö·û´® 
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomLetter(int num) {
		//±£´æÉú³Éºú×Ö·û
		StringBuffer sb = new StringBuffer();
		//Éú³ÉËæ»ú×Ö·û
		for(int i=0;i<num;i++) {
			char newChar = getRandomAzChar();
			sb.append(newChar);
		}
		return sb.toString();
	}
	
	/**
	 * @Title: getRandomNumberChar   
	 * @Description: »ñÈ¡Ëæ»úÊı×Ö×Ö·û 
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomNumberChar() {
		//Ëæ»úÀà
		Random random = new Random();
		//¿ªÊ¼×Ö·ûÔÚacsiiÂë
		int startChar = '0'+0;
		//Éú³ÉËæ»ú×Ö·û
		char newChar = (char)(startChar+random.nextInt(10));
		return newChar;
	}
	/**
	 * @Title: getRandomLetterAndNumberStr   
	 * @Description: »ñµÃËæ»ú×Ö·û´®£¨a-z0-9£©   
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomLetterAndNumberStr(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			if(random.nextInt(36)>10) {
				sb.append(getRandomAzChar());
			}else {
				sb.append(getRandomNumberChar());
			}
		}
		return sb.toString();
	}
	
	/**
	 * @Title: randomChineseString   
	 * @Description: ·µ»ØÒ»¸öÖĞÎÄÎÄ×Ö//GB2312ÖĞÎÄ¼òÌå  
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));// ÇøÂë£¬0xA0´òÍ·£¬´ÓµÚ16Çø¿ªÊ¼£¬¼´0xB0=11*16=176,16~55Ò»¼¶ºº×Ö£¬56~87¶ş¼¶ºº×Ö
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// Î»Âë£¬0xA0´òÍ·£¬·¶Î§µÚ1~94ÁĞ
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ÇøÎ»Âë×éºÏ³Éºº×Ö
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * @Title: randomChineseString   
	 * @Description: ·µ»Ø²ÎÊılength¸öÖĞÎÄºº×Ö×Ö·û´®£¬×Ö·û¼¯±ØĞëÔÚGB2312(Ïàµ±ÓÚÖĞÎÄ¼òÌå)·¶Î§ÄÚ   
	 * @param: @param length
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += randomChineseString();
		}

		return str;
	}
	/**
	 * @Title: randomChineseName   
	 * @Description: ·µ»ØÖĞÎÄĞÕÃû£¬±ØĞëÒÔÕæÊµĞÕ¿ªÍ·
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseName() {
		String[] surname = { "ÕÔ", "Ç®", "Ëï", "Àî", "ÖÜ", "Îâ", "Ö£", "Íõ", "·ë", "³Â", "ñÒ", "ÎÀ", "½¯", "Éò", "º«", "Ñî", "Öì", "ÇØ",
				"ÓÈ", "Ğí", "ºÎ", "ÂÀ", "Ê©", "ÕÅ", "¿×", "²Ü", "ÑÏ", "»ª", "½ğ", "Îº", "ÌÕ", "½ª", "Æİ", "Ğ»", "×Ş", "Ó÷", "°Ø", "Ë®", "ñ¼",
				"ÕÂ", "ÔÆ", "ËÕ", "ÅË", "¸ğ", "ŞÉ", "·¶", "Åí", "ÀÉ", "Â³", "Î¤", "²ı", "Âí", "Ãç", "·ï", "»¨", "·½", "Óá", "ÈÎ", "Ô¬", "Áø",
				"Ûº", "±«", "Ê·", "ÌÆ", "·Ñ", "Á®", "á¯", "Ñ¦", "À×", "ºØ", "Äß", "ÌÀ", "ëø", "Òó", "ÂŞ", "±Ï", "ºÂ", "Úù", "°²", "³£", "ÀÖ",
				"ÓÚ", "Ê±", "¸µ", "Æ¤", "±å", "Æë", "¿µ", "Îé", "Óà", "Ôª", "²·", "¹Ë", "ÃÏ", "Æ½", "»Æ", "ºÍ", "ÄÂ", "Ïô", "Òü", "Ò¦", "ÉÛ",
				"Õ¿", "Íô", "Æî", "Ã«", "Óí", "µÒ", "Ã×", "±´", "Ã÷", "ê°", "¼Æ", "·ü", "³É", "´÷", "Ì¸", "ËÎ", "Ã©", "ÅÓ", "ĞÜ", "¼Í", "Êæ",
				"Çü", "Ïî", "×£", "¶­", "Áº", "¶Å", "Èî", "À¶", "ãÉ", "Ï¯", "¼¾", "Âé", "Ç¿", "¼Ö", "Â·", "Â¦", "Î£", "½­", "Í¯", "ÑÕ", "¹ù",
				"Ã·", "Ê¢", "ÁÖ", "µó", "ÖÓ", "Ğì", "Çñ", "Âæ", "¸ß", "ÏÄ", "²Ì", "Ìï", "·®", "ºú", "Áè", "»ô", "Óİ", "Íò", "Ö§", "¿Â", "êÃ",
				"¹Ü", "Â¬", "Äª", "¾­", "·¿", "ôÃ", "çÑ", "¸É", "½â", "Ó¦", "×Ú", "¶¡", "Ğû", "êÚ", "µË", "Óô", "µ¥", "º¼", "ºé", "°ü", "Öî",
				"×ó", "Ê¯", "´Ş", "¼ª", "Å¥", "¹¨", "³Ì", "ïú", "ĞÏ", "»¬", "Åá", "Â½", "ÈÙ", "ÎÌ", "Ü÷", "Ñò", "ÓÚ", "»İ", "Õç", "Çú", "¼Ò",
				"·â", "ÜÇ", "ôà", "´¢", "½ù", "¼³", "Úû", "ÃÓ", "ËÉ", "¾®", "¶Î", "¸»", "Î×", "ÎÚ", "½¹", "°Í", "¹­", "ÄÁ", "Úó", "É½", "¹È",
				"³µ", "ºî", "åµ", "Åî", "È«", "Û­", "°à", "Ñö", "Çï", "ÖÙ", "ÒÁ", "¹¬", "Äş", "³ğ", "èï", "±©", "¸Ê", "î×", "À÷", "ÈÖ", "×æ",
				"Îä", "·û", "Áõ", "¾°", "Õ²", "Êø", "Áú", "Ò¶", "ĞÒ", "Ë¾", "ÉØ", "Û¬", "Àè", "¼»", "äß", "Ó¡", "ËŞ", "°×", "»³", "ÆÑ", "Û¢",
				"´Ó", "¶õ", "Ë÷", "ÏÌ", "¼®", "Àµ", "×¿", "İş", "ÍÀ", "ÃÉ", "³Ø", "ÇÇ", "Òõ", "Óô", "ñã", "ÄÜ", "²Ô", "Ë«", "ÎÅ", "İ·", "µ³",
				"µÔ", "Ì·", "¹±", "ÀÍ", "åÌ", "¼§", "Éê", "·ö", "¶Â", "È½", "Ô×", "Ûª", "Óº", "È´", "è³", "É£", "¹ğ", "å§", "Å£", "ÊÙ", "Í¨",
				"±ß", "ìè", "Ñà", "¼½", "ÆÖ", "ÉĞ", "Å©", "ÎÂ", "±ğ", "×¯", "êÌ", "²ñ", "öÄ", "ÑÖ", "³ä", "Ä½", "Á¬", "Èã", "Ï°", "»Â", "°¬",
				"Óã", "Èİ", "Ïò", "¹Å", "Ò×", "É÷", "¸ê", "ÁÎ", "â×", "ÖÕ", "ôß", "¾Ó", "ºâ", "²½", "¶¼", "¹¢", "Âú", "ºë", "¿ï", "¹ú", "ÎÄ",
				"¿Ü", "¹ã", "Â»", "ãÚ", "¶«", "Å·", "ì¯", "ÎÖ", "Àû", "Îµ", "Ô½", "Ùç", "Â¡", "Ê¦", "¹®", "ØÇ", "Äô", "êË", "¹´", "°½", "ÈÚ",
				"Àä", "ö¤", "ĞÁ", "ãÛ", "ÄÇ", "¼ò", "ÈÄ", "¿Õ", "Ôø", "Îã", "É³", "Ø¿", "Ñø", "¾Ï", "Ğë", "·á", "³²", "¹Ø", "Øá", "Ïà", "²é",
				"ºó", "¾£", "ºì", "ÓÎ", "Û£", "óÃ", "È¨", "åÖ", "¸Ç", "Òæ", "»¸", "¹«", "Øë", "¶½", "ÔÀ", "Ë§", "çÃ", "¿º", "¿ö", "àC", "ÓĞ",
				"ÇÙ", "¹é", "º£", "½ú", "³ş", "ãÆ", "·¨", "Èê", "Û³", "Í¿", "ÇÕ", "ÉÌ", "Ä²", "ÙÜ", "Ù¦", "²®", "ÉÍ", "Ä«", "¹ş", "ÚÛ", "óò",
				"Äê", "°®", "Ñô", "Ù¡", "ÑÔ", "¸£", "ÄÏ", "»ğ", "Ìú", "³Ù", "Æá", "¹Ù", "Ùş", "Õæ", "Õ¹", "·±", "Ì´", "¼À", "ÃÜ", "¾´", "½Ò",
				"Ë´", "Â¥", "Êè", "Ã°", "»ë", "Ö¿", "½º", "Ëæ", "¸ß", "¸Ş", "Ô­", "ÖÖ", "Á·", "ÃÖ", "²Ö", "íõ", "å¿", "ñû", "°¢", "ÃÅ", "ã¢",
				"À´", "ôë", "ÕÙ", "ÒÇ", "·ç", "½é", "¾Ş", "Ä¾", "¾©", "ºü", "Û¨", "»¢", "Ã¶", "¿¹", "´ï", "è½", "ÜÉ", "ÕÛ", "Âó", "Çì", "¹ı",
				"Öñ", "¶Ë", "ÏÊ", "»Ê", "ØÁ", "ÀÏ", "ÊÇ", "ÃØ", "³©", "Ú÷", "»¹", "±ö", "ãÌ", "¹¼", "×İ", "‚G", "ÍòÙ¹", "Ë¾Âí", "ÉÏ¹Ù", "Å·Ñô",
				"ÏÄºî", "Öî¸ğ", "ÎÅÈË", "¶«·½", "ºÕÁ¬", "»Ê¸¦", "ÑòÉà", "Î¾³Ù", "¹«Ñò", "å£Ì¨", "¹«Ò±", "×ÚÕı", "å§Ñô", "´¾ÓÚ", "µ¥ÓÚ", "Ì«Êå", "ÉêÍÀ",
				"¹«Ëï", "ÖÙËï", "ĞùÔ¯", "Áîºü", "ÖÓÀë", "ÓîÎÄ", "³¤Ëï", "Ä½Èİ", "ÏÊÓÚ", "ãÌÇğ", "Ë¾Í½", "Ë¾¿Õ", "Ø£¹Ù", "Ë¾¿Ü", "ÄÏÃÅ", "ºôÑÓ", "×Ó³µ",
				"ò§Ëï", "¶ËÄ¾", "Î×Âí", "¹«Î÷", "Æáµñ", "³µÕı", "ÈÀæá", "¹«Á¼", "ÍØ°Ï", "¼Ğ¹È", "Ô×¸¸", "¹ÈÁº", "¶Î¸É", "°ÙÀï", "¶«¹ù", "Î¢Éú", "ÁºÇğ",
				"×óÇğ", "¶«ÃÅ", "Î÷ÃÅ", "ÄÏ¹¬", "µÚÎå", "¹«ÒÇ", "¹«³Ë", "Ì«Ê·", "ÖÙ³¤", "ÊåËï", "ÇüÍ»", "¶ûÖì", "¶«Ïç", "ÏàÀï", "ºúÄ¸", "Ë¾³Ç", "ÕÅÁÎ",
				"ÓºÃÅ", "ÎãÇğ", "ºØÀ¼", "ôëÎã", "ÎİÂ®", "¶À¹Â", "ÄÏ¹ù", "±±¹¬", "ÍõËï" };
		// Ëæ»ú»ñÈ¡ĞÕÊÏ
		String name1 = surname[RandomUtil.random(0, surname.length - 1)];
		// Ëæ»ú»ñÈ¡1-2¸öÖĞÎÄ
		String name2 = randomChineseString(RandomUtil.random(1, 2));
		return name1 + name2;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(randomChineseName());
		}
	}
	
}
