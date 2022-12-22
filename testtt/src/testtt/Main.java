package testtt;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	Scanner scan = new Scanner (System.in);
	ArrayList<Pegawai> PegawaiData = new ArrayList<>();
	
	
	// menampilkan menu yang berada didalam aplikasi 
	public void Menu() {
		System.out.println("Sistem Informasi Sekolah");
		System.out.println("1. Add new member");
		System.out.println("2. View all member");
		System.out.println("3. Tarik Gaji");
		System.out.println("4. Delete Data");
		System.out.println("5. Exit");
		System.out.println("Silahkan Pilih satu nomor");
		System.out.print(">> ");	
		
	}
	
	// menambahkan data member
	public void addNewMember() {
		String name = "";
		String gender = "";
		String noHp = "";
		String email= "";
		String status= "";
		String alamat= "";
		int kelas = 0 ;
		String course= "";
		int room = 0 ;
		String education = "";
		String jenisMakanan= "";
		boolean trigger = false;
		String loyaltyCardID = "";
		Integer Gaji = 0;
		Integer jamKerja = 0;
		
		// Validasi nama 
		do {
			System.out.print("Input name: ");
			name = scan.nextLine();
		}while(name.length() < 5 || name.length() > 20);
		
		// validasi gender
		do {
			System.out.print("Input gender: ");
			gender = scan.nextLine();
		}while(!(gender.equals("Male") || gender.equals("Female")));
		// !(gender.equals("Male") && gender.equals("Female"))
		
		// validasi no HP
		do {
			boolean isAllDigit = true;
			boolean numberLength = false;
			
			System.out.print("Input phone number: ");
			noHp = scan.nextLine();
			
			for(int i = 0; i < noHp.length(); i++) {
				Character temp = noHp.charAt(i);
				if(!temp.isDigit(temp)) {
					isAllDigit = false;
					break;
				}
			}
			
			if(noHp.length() == 12) numberLength = true;
			if(isAllDigit == true && numberLength == true) {
				trigger = true;
			}
		}while(trigger == false);
		
		// validasi status
		do {
			System.out.print("Input status: ");
			status = scan.nextLine();
		}while(!(status.equals("Siswa") || status.equals("Guru") || status.equals("OB")|| status.equals("Staff")|| status.equals("Pedagang")));
		
		
		// validasi email
			do {
				System.out.print("Input email: ");
				email = scan.nextLine();
			}while(!(email.endsWith("@gmail.com")));
			
		// validasi alamat
		
			System.out.print("Input alamat:");
			alamat = scan.nextLine();
			
		
		// buat loyalyId
			loyaltyCardID = genLoyaltyCard(status);
			
		// validasi kelas;
			if(status.equals("Siswa")) {
				do {
					System.out.print("Input kelas: ");
					kelas = scan.nextInt();
					scan.nextLine();
				}while(kelas < 10 || kelas > 12);
				PegawaiData.add(new Siswa(name, gender, noHp, email, status, alamat,loyaltyCardID, Gaji, kelas));
				
				// validasi course;
			}else if(status.equals("Guru")){
					System.out.print("Input mata pelajaran yang diajarkan: ");
					course = scan.nextLine();
					PegawaiData.add(new Guru(name, gender, noHp, email, status, alamat,loyaltyCardID,Gaji, course, jamKerja));
			}else if(status.equals("OB")){
				// validasi room
				do {
					System.out.print("Input tugas pembersihan room:");;
					room = scan.nextInt();
					scan.nextLine();
				} while(room <= 15);
					System.out.print("Input jam kerja : ");
					jamKerja = scan.nextInt();
					scan.nextLine();
				PegawaiData.add(new OB(name, gender, noHp, email, status, alamat,loyaltyCardID, Gaji,room,jamKerja));
			}else if(status.equals("Staff")){
				do {
					// validasi education
					System.out.print("Input pendidikan terakhir");
					education = scan.nextLine();
				}while((education.equals("S1") == false)|| (education.equals("D3") == false)|| (education.equals("D2") == false));
				System.out.print("Input jam kerja : ");
				jamKerja = scan.nextInt();
				scan.nextLine();
				PegawaiData.add(new Staff(name, gender, noHp, email, status, alamat, loyaltyCardID,Gaji,education,jamKerja));
			}else if(status.equals("Pedagang")){
				// validasi jenisMakanan
				System.out.println("Input makanan yang di jual: ");
				jenisMakanan = scan.nextLine();
				System.out.print("Input jam kerja : ");
				jamKerja = scan.nextInt();
				scan.nextLine();
				PegawaiData.add(new PedagangKantin(name, gender, noHp, email, status, alamat, loyaltyCardID,Gaji, jenisMakanan,jamKerja));
			}
			System.out.println("Data has been add!");
	}
	
	// akan memberikan loyaltyCard kepada masing masing status
	String genLoyaltyCard(String status) {
		String ID = "";
		
		if(status.equals("Siswa")) {
			ID = "S";
			for(int i = 0; i < 5; i++) {
				int temp = (int)((Math.random()*(9-1)) + 1);
				ID += temp;
			}
		}else if(status.equals("Guru")){
			ID = "G";
			for(int i = 0; i < 5; i++) {
				int temp = (int)((Math.random()*(9-1)) + 1);
				ID += temp;
			}
		}else if(status.equals("OB")) {

			ID = "O";
			for(int i = 0; i < 5; i++) {
				int temp = (int)((Math.random()*(9-1)) + 1);
				ID += temp;
			}
		
		}else if(status.equals("Staff")) {

			ID = "F";
			for(int i = 0; i < 5; i++) {
				int temp = (int)((Math.random()*(9-1)) + 1);
				ID += temp;
			}
		
		}else if(status.equals("Pedagang")) {

			ID = "P";
			for(int i = 0; i < 5; i++) {
				int temp = (int)((Math.random()*(9-1)) + 1);
				ID += temp;
			}
		
		}
		return ID;
	}
	
	
	
	// menampilkan member yang telah di add
	public void viewMember() {
		// jika belum ada data maka sistem akan menampilkan tampilan "Tidak ada member".
		if(PegawaiData.isEmpty()) {
			System.out.println("Tidak ada Member");
		}else {
			int counter = 0;
			// name , gender , no hp , status,alamat,email, kelas, course, room , education , jenis makanan, jam kerja
			System.out.printf("|%-5s | %-6s | %-16s | %-7s | %-12s | %-12s | %-25s | %-25s | %-10s | %-10s | %-10s | %-10s |%-10s | %-10s| \n",
					"No" ,"Name","LoyaltyId", "Gender", "No Hanphone", "Status",  "Alamat Rumah", "Email" , "Kelas" , "Course" , "Room" ," Education", "Jenis Makanan", "Jam kerja");
			for(Pegawai c : PegawaiData) {
				counter++;
				if(c instanceof Siswa) {
					System.out.printf("|%-5s | %-6s | %-16s | %-7s | %-12s | %-12s | %-25s | %-25s | %-10d | %-10s | %-10s | %-10s |%-10s | %-10s | \n",
							counter, c.getName(), c.getLoyaltyCardID(),c.getGender(), c.getNoHp(), c.getStatus(), c.getAlamat(), c.getEmail(), ((Siswa)c).getKelas(),"-","-","-","-","-");
 			}else if(c instanceof Guru) {
				System.out.printf("|%-5s | %-6s | %-16s | %-7s | %-12s | %-12s | %-25s | %-25s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10d | \n",
						counter, c.getName(), c.getLoyaltyCardID(),c.getGender(), c.getNoHp(), c.getStatus(),c.getAlamat(), c.getEmail() , "-",((Guru)c).getCourse(),"-","-","-",((Guru)c).getJamKerja());
			}else if(c instanceof OB) {
				System.out.printf("|%-5s | %-6s | %-16s | %-7s | %-12s | %-12s | %-25s | %-25s | %-10s | %-10s | %-10d | %-10s | %-10s | %-10d | \n",
						counter, c.getName(), c.getLoyaltyCardID(),c.getGender(), c.getNoHp(), c.getStatus(), c.getEmail() ,"-","-", ((OB)c).getRoom(),"-","-",((OB)c).getJamKerja());		
			}else if(c instanceof Staff) {

				System.out.printf("|%-5s | %-6s | %-16s | %-7s | %-12s | %-12s | %-25s | %-25s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10d | \n",
						counter, c.getName(), c.getLoyaltyCardID(),c.getGender(), c.getNoHp(), c.getStatus(), c.getEmail() ,"-","-","-", ((Staff)c).getEducation(),"-",((Staff)c).getJamKerja());
					
			}else if ( c instanceof PedagangKantin ) {
				System.out.printf("|%-5s | %-6s | %-16s | %-7s | %-12s | %-12s | %-25s | %-25s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10d | \n",
						counter, c.getName(),c.getLoyaltyCardID(), c.getGender(), c.getNoHp(), c.getStatus(), c.getEmail(), c.getGaji() ,"-", "-","-","-",((PedagangKantin)c).getJenisMakanan(),((PedagangKantin)c).getJamKerja());
			}
			}
		}
	}
	
	
	// gaji dia akan bertambah seiring banyaknya points dia bekerja
	public void JamBekerja() {

		if(PegawaiData.isEmpty()) {
			System.out.println("Tidak ada Member");
		}
		viewMember();
		
		String tempID="";
		System.out.print("Input id: ");
		tempID = scan.nextLine();
		
		for(Pegawai c: PegawaiData) 
		{
			if(c.getLoyaltyCardID().equals(tempID)) 
			{
				// siswa tidak akan mendapatkan gaji
				if(c instanceof Siswa)
				{
					System.out.println("Anda adalah siswa");
					return;
				}
				c.setGaji(c.generatePoint());
				System.out.println("Anda mendapatkan Rp" + c.getGaji() + ".000.000 sebagai gaji anda!");
				System.out.println("Thank you");
				System.out.println();
				return;
			}
		}
	}
	

	// validasi untuk mendelete data yang telah ada sebelumnya
	public void Delete() {

		int deleteVar;
		viewMember();
		
		System.out.print("Hapus data ke berapa [1-" + PegawaiData.size() + "]?: ");
		deleteVar = scan.nextInt();
		scan.nextLine();
		

		System.out.println(PegawaiData.get(deleteVar-1).getLoyaltyCardID() + " telah dihapus!");
		PegawaiData.remove(deleteVar-1);
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
	
	}

	public Main() {
		// codingan untuk memilih data mana yang akan dijalankan
		int choose = 0;
		do {
			Menu();
			choose = scan.nextInt();
			scan.nextLine();
			
			switch (choose) {
			case 1:
				addNewMember();
				break;
			case 2:
				viewMember();
				break;
			case 3:
				JamBekerja();
			case 4:
				Delete();
			case 5:
				return;
			case 0:
				//keluar dari program
				break;
				default:
					System.out.println("Pilihan tidak valid");
					break;
			}
		}while(choose != 7);
	
		
	
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
