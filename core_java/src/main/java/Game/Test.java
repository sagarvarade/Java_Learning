package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		//request();
		//response();
		
		int a=10;
		int b=20;
		calc(a,b);
		System.out.println(a+"  "+b);
		
		List<Integer> intList=new ArrayList<Integer>(List.of(20,40));
		calc2( (List<Integer>) Collections.unmodifiableCollection(intList));
		
		System.out.println("Main Class : "+intList.toString());
	}

	private static void calc2( List<Integer> intList) {
		intList.add(45);
		System.out.println("Method Class : "+intList.toString());
	}

	private static void calc(int a, int b) {
		a=100;
		b=200;
		System.out.println(a+"  "+b);
	}

	private static void request() {
		String request="""
				2,PAN
				4,AMOUNT
				5,AMOUNTSETTLE
				6,AMOUNTCHBILL
				7,TRANSTIME   
				9,RATESETTLE  
				10,RATECHBILL 
				11,STAN 
				12,TIME 
				13,DATE 
				14,EXPIRY     
				15,DTSETTLE
				16,DTCONVERSION
				18,MCAT
				19,COUNTRY
				20,PAN_EXT_CC 
				22,PANENTRY
				23,CSEQ
				25,CONDCODE
				26,POSPINCC
				28,SURCHARGE
				32,AIIC
				33,FIIC
				34,ECOM_DATA
				35,TRACK2
				37,RRN 
				38,AIR
				39,RC
				41,TID
				42,MID
				43,LOC_OWNER
				44,DE44
				45,TRACK1
				48,ADDDATA
				49,CURRENCY
				50,CURRENCYSETTLE
				51,CURRENCYCHBILL
				52,PAC
				53,SECRELATEDINFO
				54,ADDAMT
				55,EMV
				59,POSGEODATA
				60,DE60
				61,DE61
				62,DE62
				63,DE63_BMP
				68,RICC
				69,SICC
				70,NMIC
				74,CRE_NR
				75,CRE_REV_NR
				76,DEB_NR
				77,DEB_REV_NR
				86,CRE_AMT
				87,CRE_REV_AMT
				88,DEB_AMT
				89,DEB_REV_AMT
				90,ENF_ORIGDATAELE
				91,FILE_UPDATE_CODE
				92,FILE_SECURITY_CODE
				95,DE95
				97,AMT_NET_SETTL
				99,SIIC
				100,RIIC
				101,FILE_NAME
				102,ACCOUNT_IDENTIFICATION_1
				103,ACCOUNT_IDENTIFICATION_2
				104,TRANSDESCRIPTION
				111,VI_DE111
				115,ADDTRACEDATA
				121,ISS_INST_ID_CODE
				123,INCR_FINGERPRINT
				126,DE126
				""";
		String [] x =request.split("\n");
		System.out.println("REQuest >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(String str:x) {
			String[] spl=str.split(",");
			String tag=spl[0].trim();
			String tagval=spl[1].trim();
			
			String tagGen="<xsl:if test=\"$fieldsPath/"+tagval+"/tiers/IN and $fieldsPath/"+tagval+"/tiers/IN !=\'\' \">"
					+ "<fld_"+tag+"><XsltPrimitive><stringValue>"
					+"<xsl:value-of select=\"$fieldsPath/"+tagval+"/tiers/IN\"/>"
					+"</stringValue></XsltPrimitive></fld_"+tag+"></xsl:if>";
			System.out.println(tagGen);
		}
	}

	private static void response() {
		System.out.println("response >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
		String response = """
				2,PAN
				4,AMOUNT
				5,AMOUNTSETTLE
				6,AMOUNTCHBILL
				7,TRANSTIME
				9,RATESETTLE
				10,RATECHBILL
				11,STAN
				12,DT
				13,TRANSTIME
				14,EXPIRY
				15,DTSETTLE
				18,MCAT
				19,COUNTRY
				22,PANENTRY
				23,CSEQ
				25,CSEQ
				32, AIIC
				37,RRN
				39,RC
				38,AIR
				41,TID
				42,MID
				44,DE44
				48,ADDDATA
				49,CURRENCY
				50,CURRENCYSETTLE
				51,CURRENCYCHBILL
				54,ADDAMT,
				55,EMV
				62,TRANS_ID
				70,NMIC
				90,ENF_ORIGDATAELE
				95,TRANFEE
				102,ACCOUNT_IDENTIFICATION_1
				103,ACCOUNT_IDENTIFICATION_2
								""";
		String[] x = response.split("\n");
		for (String str : x) {
			String[] spl = str.split(",");
			String tag = spl[0].trim();
			String tagval = spl[1].trim();

			String tagGen = "<xsl:if test=\"$fieldsPath/" + tagval + "/tiers/OT and $fieldsPath/" + tagval
					+ "/tiers/OT !=\'\' \">" + "<fld_" + tag + "><XsltPrimitive><stringValue>"
					+ "<xsl:value-of select=\"$fieldsPath/" + tagval + "/tiers/OT\"/>"
					+ "</stringValue></XsltPrimitive></fld_" + tag + "></xsl:if>";
			System.out.println(tagGen);

		}

	}
}
