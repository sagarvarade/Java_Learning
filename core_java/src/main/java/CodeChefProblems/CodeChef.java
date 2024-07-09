package CodeChefProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeChef {
	public static void main(String[] args) {
		// https://www.codechef.com/problems/R5S
		// R5s();

		// https://www.codechef.com/problems/CANDYSTORE
		// CANDYSTORE();

		// https://www.codechef.com/problems/ASSIGNMNT
		// ASSIGNMNT();

		// https://www.codechef.com/problems/AIRLINES
		// AIRLINES();

		// https://www.codechef.com/problems/SPCP1
		// SPCP1();
		// https://www.codechef.com/problems/NETFLIX
		// NETFLIX();
		// https://www.codechef.com/problems/CPRIVAL
		// CPRIVAL();

		// https://www.codechef.com/problems/CRICMATCH
		// CRICMATCH();
		// https://www.codechef.com/problems/LITRATE
		// LITRATE();
		// https://www.codechef.com/problems/EXAMCHEF
		// EXAMCHEF();
		// https://www.codechef.com/problems/NGRS
		// NGRS();
		// https://www.codechef.com/problems/WATERFILLING
		// WATERFILLING();
		// https://www.codechef.com/problems/PHONEYR
		// PHONEYR();
		// https://www.codechef.com/problems/PIZZAC
		// PIZZAC();
		// https://www.codechef.com/problems/PAINTCHRIS
		// PAINTCHRIS();
		// https://www.codechef.com/problems/SEVENRINGS
		// SEVENRINGS();
		// https://www.codechef.com/problems/MONOPOLY2
		// MONOPOLY2();
		// https://www.codechef.com/problems/BETDEAL
		// BETDEAL();
		// https://www.codechef.com/problems/LASTLEVELS
		// LASTLEVELS();
		// https://www.codechef.com/problems/XJUMP
		// XJUMP();
		// https://www.codechef.com/problems/CHESSDIST
		// CHESSDIST();
		// https://www.codechef.com/problems/FOODPLAN
		// FOODPLAN();
		// https://www.codechef.com/problems/SELFDEF
		// SELFDEF();
		// https://www.codechef.com/problems/CRICUP
		// https://www.codechef.com/problems/JGAMES
		// JGAMES();
		// https://www.codechef.com/problems/ECOCLASS
		// ECOCLASS();
		// https://www.codechef.com/problems/RCBPLAY
		// RCBPLAY();
		// https://www.codechef.com/problems/LAZYCHF
		// LAZYCHF();
		// https://www.codechef.com/problems/FINDK3
		// FINDK3();
		// https://www.codechef.com/problems/HARDBET
		// HARDBET();
		// https://www.codechef.com/problems/WORDLE
		// WORDLE();
		// https://www.codechef.com/problems/CREDITS
		// CREDITS();
		// https://www.codechef.com/problems/SUPCHEF
		// SUPCHEF();
		// https://www.codechef.com/problems/GENE01
		// GENE01();
		// https://www.codechef.com/problems/FLOW014
		// FLOW014();
		// https://www.codechef.com/problems/VOWELTB
		// VOWELTB();
		// https://www.codechef.com/problems/BMI
		// BMI();
		// https://www.codechef.com/problems/CHEFTRANS
		// CHEFTRANS();
		// https://www.codechef.com/problems/VISA
		//VISA();
		//https://www.codechef.com/problems/DRUNKALK
		//DRUNKALK();
		//https://www.codechef.com/problems/CARRYGOLD
		//CARRYGOLD();
		//https://www.codechef.com/problems/EXISTENCE
		//EXISTENCE();
		//Test();
		//https://www.codechef.com/problems/DEVSPORTS
		//DEVSPORTS();
		//https://www.codechef.com/problems/CARCHOICE
		//CARCHOICE();
		//https://www.codechef.com/problems/UTKPLC
		//UTKPLC();
		//https://www.codechef.com/problems/OLYRANK
		//OLYRANK();
		//https://www.codechef.com/problems/HOWMANY
		HOWMANY();
		
	}


	private static void HOWMANY() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			String x="";
			if(t>0 && t<10)
				x="1";
			else if(t>=10 && t<100)
				x="2";
			else if (t>=100 && t<1000)
				x="3";
			else 
				x="More than 3 digits";
			System.out.println(x);
		}
	}


	private static void OLYRANK() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();

				if (a + b + c > x + y + z) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}

			}
		}
	}


	private static void UTKPLC() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				char A=sc.next().charAt(0);
			    char B=sc.next().charAt(0);
			    char C=sc.next().charAt(0);
			    char a=sc.next().charAt(0);
			    char b=sc.next().charAt(0);
			    if(a==A ||b==A ){
			        System.out.println(A);
			    }
			    else{
			        System.out.println(B);
			    }
			}
		}
	}


	private static void CARCHOICE() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				float x1 = sc.nextInt();
				float x2 = sc.nextInt();
				float y1 = sc.nextInt();
				float y2 = sc.nextInt();
				float c1 = y1 / x1;
				float c2 = y2 / x2;
				if (c1 < c2) {
					System.out.println("-1");
				} else if (c1 > c2) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			}
		}
	}

	private static void DEVSPORTS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int z = scanner.nextInt();
			    int y = scanner.nextInt();
			    int a = scanner.nextInt();
			    int b = scanner.nextInt();
			    int c = scanner.nextInt();
			    
			    if((a+b+c)<=(z-y)) {
			    	System.out.println("YES");
			    }else
			    	System.out.println("NO");
			}
		}
	}

	private static void Test() {
		Map<String, String> bankMap = new HashMap<>();
        bankMap.put("BRI", "Bank Rakyat Indonesia");
        bankMap.put("MDR", "Bank Mandiri");
        bankMap.put("BNI", "Bank Negara Indonesia");
        bankMap.put("BTN", "Bank Tabungan Negara");
        bankMap.put("JPN", "PT. Jalin Pembayaran Nusantara");
        bankMap.put("SAT", "Artajasa");
        bankMap.put("RTS", "Prima");
        bankMap.put("ALT", "Alto");
        bankMap.put("BIS", "Bank BNI Syariah");
        bankMap.put("BSR", "Bank BRI Syariah");
        bankMap.put("KAS", "BPD Kalsel");
        bankMap.put("NTB", "BANK NTB");
        bankMap.put("GNS", "Bank Ganesha");
        bankMap.put("BSM", "Bank Syariah Mandiri");
        bankMap.put("BMI", "Bank Maspion");
        bankMap.put("MTP", "BANK MANTAP");
        bankMap.put("BAL", "BANK ALADIN");
        bankMap.put("BKL", "Bank Bengkulu");
        bankMap.put("NUT", "BANK NTT");
        bankMap.put("RYA", "Bank Raya");
        bankMap.put("LMP", "Bank Lampung");
        bankMap.put("CBC", "Bank ICBC");
        bankMap.put("DSP", "Digital Solusi Pratama");
        bankMap.put("SUL", "Bank Sulteng");
		
        
        String data="""
				BANKCODE=002|BANKNAME=Bank Rakyat Indonesia|batchKey=002|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BRI |
				BANKCODE=007|BANKNAME=ARTAJASA|batchKey=360001|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=SAT |
				BANKCODE=008|BANKNAME=BANK MANDIRI|batchKey=008|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=MDR |
				BANKCODE=009|BANKNAME=Bank Negara Indonesia|batchKey=009|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BNI |
				BANKCODE=121|BANKNAME=Bank Lampung|batchKey=121|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=LMP |
				BANKCODE=122|BANKNAME=BPD Kalsel|batchKey=122|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=KAS |
				BANKCODE=128|BANKNAME=BANK NTB|batchKey=128|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=NTB |
				BANKCODE=130|BANKNAME=BANK NTT|batchKey=130|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=NUT |
				BANKCODE=133|BANKNAME=Bank Bengkulu|batchKey=133|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BKL |
				BANKCODE=134|BANKNAME=Bank Sulteng|batchKey=134|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=SUL |
				BANKCODE=157|BANKNAME=Bank Maspion|batchKey=157|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BMI |
				BANKCODE=161|BANKNAME=BANK GANESHA|batchKey=161|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=GNS |
				BANKCODE=164|BANKNAME=Bank ICBC|batchKey=164|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=CBC |
				BANKCODE=200|BANKNAME=Bank BTN|batchKey=200|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BTN |
				BANKCODE=360001|BANKNAME=SAT|batchKey=360001|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=SAT |
				BANKCODE=360002|BANKNAME=RTS|batchKey=360002|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=RTS |
				BANKCODE=360003|BANKNAME=ALT|batchKey=360003|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=ALT |
				BANKCODE=360004|BANKNAME=JALIN|batchKey=360004|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=JLN |
				BANKCODE=360991|BANKNAME=STANDARD|batchKey=360991|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=STD |
				BANKCODE=360992|BANKNAME=SERVICE|batchKey=360992|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=SVC |
				BANKCODE=422|BANKNAME=Bank BRI Syariah|batchKey=422|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BSR |
				BANKCODE=427|BANKNAME=Bank BNI Syariah|batchKey=427|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BIS |
				BANKCODE=451|BANKNAME=Bank Syariah Mandiri|batchKey=451|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BSM |
				BANKCODE=494|BANKNAME=AGR|batchKey=494|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=AGR |
				BANKCODE=564|BANKNAME=BANK MANTAP|batchKey=564|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=MTP |
				BANKCODE=947|BANKNAME=BANK ALADIN|batchKey=947|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=BAL |
				BANKCODE=998|BANKNAME=Digital Solusi Pratama|batchKey=998|01_ACQ_SUCCESS|header1=LAPORAN AKTIVITAS ACQUIRER|header2=TRANSAKSI POINT OF SALE BERHASIL|reportCode=54|FILE=Acquirer|reportDate={nextDate}{dateFormat=dd/MM/yyyy}|BANKCODE_FOR_FILE_NAME=DSP |
        		""";
        
        String[] lines = data.split("\n");
        for (String line : lines) {
        	String BANKCODE=extractValue(line,"BANKCODE").replace("=", "").trim();
        	String BANKCODE_FOR_FILE_NAME=extractValue(line,"BANKCODE_FOR_FILE_NAME").replace("=", "").trim();
        	String fullBankName = bankMap.get(BANKCODE_FOR_FILE_NAME);
            if(fullBankName!=null) {
            	System.out.println("INSERT INTO renaissance_property (category, property_name, property_value) VALUES (\'3325_static_batch\',\'"+BANKCODE+"|1_DEBIT_SWITCH_REVENUE_"+BANKCODE+"\',\'1;TRANS;BANK_NAME_INITIALS="+BANKCODE_FOR_FILE_NAME+"|BANK_NAME="+fullBankName+"\');");
            	System.out.println("INSERT INTO renaissance_property (category, property_name, property_value) VALUES (\'3325_static_batch\',\'"+BANKCODE+"|2_DEBIT_SWITCH_REVENUE_"+BANKCODE+"\',\'2;DISPUTE;BANK_NAME_INITIALS="+BANKCODE_FOR_FILE_NAME+"|BANK_NAME="+fullBankName+"\');");
            }
        }
	}
	
	
	private static String extractValue(String input, String key) {
        int startIndex = input.indexOf(key);
        if (startIndex != -1) {
            startIndex += key.length();
            int endIndex = input.indexOf('|', startIndex);
            if (endIndex != -1) {
                return input.substring(startIndex, endIndex);
            } else {
                return input.substring(startIndex);
            }
        }
        return null;
    }
	private static void EXISTENCE() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				double X1=Math.pow(x, 4)+4*Math.pow(y, 2);
				double Y1=4*Math.pow(x, 2)*y;
				if(X1==Y1)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	private static void CARRYGOLD() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				int x=sc.nextInt()+1;
			    int y=sc.nextInt();
			    int z=sc.nextInt();
			    if(x*z>=y)
			    {
			    	System.out.println("YES");
			    }else
			    	System.out.println("NO");
			}
		}
	}

	private static void DRUNKALK() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				int x1=sc.nextInt();
				int step=0;
				for(int i=1;i<=x1;i++) {
					if(step%2!=0) {
						step=step-1;
					}
					else
						step=step+3;
				}
				System.out.println(step);
			}
		}
	}

	private static void VISA() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t-- > 0) {
				int x1=sc.nextInt();
			    int x2=sc.nextInt();
			    int y1=sc.nextInt();
			    int y2=sc.nextInt();
			    int z1=sc.nextInt();
			    int z2=sc.nextInt();
			    if(x2>=x1 && y2>=y1 && z2<=z1)
			    {
			        System.out.println("YES");
			    }
			    else{
			        System.out.println("NO");
			    }
			}
		}
	}

	private static void CHEFTRANS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				if ((x + y) < z) {
					System.out.println("PLANEBUS");
				} else if ((x + y) > z) {
					System.out.println("TRAIN");
				} else {
					System.out.println("EQUAL");
				}
			}
		}

	}

	private static void BMI() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int mass = scanner.nextInt();
				int height = scanner.nextInt();
				int sum = mass / (height * height);
				if (sum <= 18)
					System.out.println(1);
				else if (19 <= sum && sum <= 24)
					System.out.println(2);
				else if (25 <= sum && sum <= 29)
					System.out.println(3);
				else
					System.out.println(4);
			}
		}
	}

	private static void VOWELTB() {
		try (Scanner scanner = new Scanner(System.in)) {
			char ch = scanner.next().charAt(0);
			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				System.out.println("Vowel");
			} else
				System.out.println("Consonant");

		}
	}

	private static void FLOW014() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				double h = scanner.nextDouble();
				double cr = scanner.nextDouble();
				double ten = scanner.nextDouble();
				if (h > 50 && cr < 0.7 && ten > 5600) {
					System.out.println("10");
				} else if (h > 50 && cr < 0.7) {
					System.out.println("9");
				} else if (cr < 0.7 && ten > 5600) {
					System.out.println("8");
				} else if (h > 50 && ten > 5600) {
					System.out.println("7");
				} else if (h > 50 || cr < 0.7 || ten > 5600) {
					System.out.println("6");
				} else {
					System.out.println("5");
				}
			}
		}

	}

	private static void GENE01() {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.next();
			String b = scanner.next();
			if (a == "R" || b == "R") {
				System.out.println("R");
			} else if (a == "B" || b == "B") {
				System.out.println("B");
			} else {
				System.out.println("G");
			}
		}

	}

	private static void SUPCHEF() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				if (x > (y * z))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	private static void CREDITS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				String op = "";
				if (x < 35)
					op = "Underload";
				else if (x >= 35 && x <= 65)
					op = "Normal";
				else
					op = "Overload";
				System.out.println(op);
			}
		}
	}

	private static void WORDLE() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				String x1 = scanner.next();
				String y1 = scanner.next();
				String op = "";
				for (int i = 0; i < x1.length(); i++) {
					char x = x1.charAt(i);
					char y = y1.charAt(i);
					if (x == y)
						op = op + "G";
					else
						op = op + "B";
				}
				System.out.println(op);
			}
		}
	}

	private static void HARDBET() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				if (b < c) {
					if (b < a) {
						System.out.println("Bob");
					} else {
						System.out.println("Draw");
					}

				} else {
					if (c < a) {
						System.out.println("Alice");
					} else {
						System.out.println("Draw");
					}
				}
			}
		}
	}

	private static void FINDK3() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int X = scanner.nextInt();
				int Y = scanner.nextInt();
				int Z = scanner.nextInt();
				if ((X * Y) % Z == 0) {
					System.out.println((X * Y) + " " + Z);
				} else if ((Y * Z) % X == 0) {
					System.out.println((Z * Y) + " " + X);
				} else if ((X * Z) % Y == 0) {
					System.out.println((Z * X) + " " + Y);
				} else {
					System.out.println(-1);
				}
			}
		}
	}

	private static void LAZYCHF() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				int delay = x * y;
				int maxTime = x + z;
				int min = Math.min(delay, maxTime);
				System.out.println(min);
			}
		}
	}

	private static void RCBPLAY() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				if ((x + (z * 2)) >= y)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
		}
	}

	private static void ECOCLASS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int loopSize = scanner.nextInt();
				int op = 0;
				int[] x = new int[loopSize];
				for (int i = 0; i < loopSize; i++) {
					x[i] = scanner.nextInt();
				}
				for (int i = 0; i < loopSize; i++) {
					if (x[i] == scanner.nextInt()) {
						op++;
					}
				}
				System.out.println(op);
			}
		}
	}

	private static void JGAMES() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				if ((x + y) % 2 == 0)
					System.out.println("janmansh");
				else
					System.out.println("jay");
			}
		}

	}

	private static void SELFDEF() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int ages = scanner.nextInt();
				int count = 0;
				while (ages-- > 0) {
					int ag = scanner.nextInt();
					if (ag >= 10 && ag <= 60) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
	}

	private static void FOODPLAN() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				double online = x1 - (x1 * 0.10);
				if (online < y1) {
					System.out.println("ONLINE");
				} else if (online > y1) {
					System.out.println("DINING");
				} else {
					System.out.println("EITHER");
				}
			}
		}

	}

	private static void CHESSDIST() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				int x2 = scanner.nextInt();
				int y2 = scanner.nextInt();
				int max = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
				System.out.println(max);
			}
		}
	}

	private static void XJUMP() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int stairs = scanner.nextInt();
				int leap = scanner.nextInt();
				int count = stairs / leap;
				if (stairs % leap != 0) {
					count = count + stairs % leap;
				}
				System.out.println(count);
			}
		}
	}

	private static void LASTLEVELS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				if (x % 3 != 0) {
					int Br = x / 3;
					System.out.println(x * y + (Br * z));
				} else if (x % 3 == 0) {
					int Br = (x / 3) - 1;
					System.out.println(x * y + (Br * z));
				} else {
					System.out.println(x * y);
				}
			}
		}

	}

	private static void BETDEAL() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				double priceA = 100 - (((double) x / 100) * 100);
				double priceB = 200 - (((double) y / 100) * 200);
				if (priceA < priceB) {
					System.out.println("FIRST");
				} else if (priceA > priceB) {
					System.out.println("SECOND");
				} else {
					System.out.println("BOTH");
				}
			}
		}
	}

	private static void MONOPOLY2() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			int[] ary = new int[4];
			while (t-- > 0) {
				ary[0] = scanner.nextInt();
				ary[1] = scanner.nextInt();
				ary[2] = scanner.nextInt();
				ary[3] = scanner.nextInt();
				Arrays.sort(ary);
				int thre = ary[0] + ary[1] + ary[2];
				if (thre < ary[3]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void SEVENRINGS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				if ((x * y) >= 10000 && (x * y) <= 99999) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void PAINTCHRIS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt() / 2;
				System.out.println(z / (x * y));
			}
		}
	}

	private static void PIZZAC() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				System.out.println(x % 2 == 0 || x == 1 ? "YES" : "NO");
			}
		}
	}

	private static void PHONEYR() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			if (t > 100) {
				String x = String.valueOf(t);
				System.out.println("K" + x.substring(x.length() - 2));
			}
		}
	}

	private static void WATERFILLING() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				if ((x + y + z) <= 1)
					System.out.println("Water filling time");
				else
					System.out.println("Not now");
			}
		}
	}

	private static void NGRS() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int attend = scanner.nextInt();
				int marks = scanner.nextInt();
				String grade = "";
				if (attend < 50) {
					grade = "Z";
				} else if (marks < 50 && attend >= 50) {
					grade = "F";
				} else {
					grade = "A";
				}
				System.out.println(grade);
			}
		}
	}

	private static void EXAMCHEF() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int schol = scanner.nextInt();
				int stude = scanner.nextInt();
				int passed = scanner.nextInt();
				double passPer = ((double) passed / (schol * stude)) * 100;
				System.out.println(passPer >= 50 ? "YES" : "NO");
			}
		}
	}

	private static void LITRATE() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int pop = scanner.nextInt();
				int literate = scanner.nextInt();
				double popav = ((double) literate / pop) * 100;
				System.out.println(popav);
				System.out.println(popav >= 75 ? "YES" : "NO");
			}
		}

	}

	private static void CRICMATCH() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int run = scanner.nextInt();
				int over = scanner.nextInt();
				System.out.println(run <= (over * 6 * 6) ? "YES" : "NO");
			}
		}
	}

	private static void CPRIVAL() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int a1 = a + x;
			int b1 = b + y;
			if (a1 > b1) {
				System.out.println("Dominater");
			} else {
				System.out.println("Everule");
			}
		}
	}

	private static void NETFLIX() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				int d = scanner.nextInt();
				System.out.println((((a + b) >= d) || ((b + c) >= d) || ((a + c) >= d)) ? "YES" : "NO");
			}
		}

	}

	private static void SPCP1() {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			System.out.println((h <= 130) && (w >= 60) ? "YES" : "NO");
		}
	}

	private static void AIRLINES() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int cap = scanner.nextInt();
				int psngr = scanner.nextInt();
				int cost = scanner.nextInt();

				int totalCap = cap * 10;
				int sum = 0;
				if (psngr <= totalCap) {
					sum = psngr * cost;
				} else if (psngr > totalCap) {
					sum = totalCap * cost;
				}
				System.out.println(sum);
			}
		}
	}

	private static void ASSIGNMNT() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int z = scanner.nextInt();
				System.out.println((x * y) <= (z * 24 * 60) ? "YES" : "NO");
			}
		}
	}

	private static void CANDYSTORE() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				if (x > y) {
					System.out.println(y);
				} else if (x == y) {
					System.out.println(y);
				} else if (x < y) {
					System.out.println(x + (y - x) * 2);
				}
			}
		}
	}

	private static void R5s() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a + b >= 200)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
