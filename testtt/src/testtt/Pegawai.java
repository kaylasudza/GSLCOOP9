package testtt;
// Pegawai sebagai abstract class
public abstract class Pegawai {
	
	// Abstract class Pegawai akan mengimplementasikan 
	// interface Orang
	// dan menambahkan informasi tambahan tentang pegawai, 
	// seperti nomor pegawai dan gaji.
	
	private String name;
	private String gender;
	private String noHp;
	private String email;
	private String status;
	private String alamat;
	private String loyaltyCardID;
	private Integer Gaji;
	
	public Pegawai(String name, String gender, String noHp, String email, String status, String alamat, String loyaltyCardID,Integer Gaji) {
		super();
		this.name = name;
		this.gender = gender;
		this.noHp = noHp;
		this.email = email;
		this.status = status;
		this.alamat = alamat;
		this.loyaltyCardID = loyaltyCardID;
		this.Gaji = Gaji;
	}

	
	public Integer getGaji() {
		return Gaji;
	}


	public void setGaji(Integer gaji) {
		Gaji = gaji;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}


	public String getLoyaltyCardID() {
		return loyaltyCardID;
	}


	public void setLoyaltyCardID(String loyaltyCardID) {
		this.loyaltyCardID = loyaltyCardID;
	}
	
	// menmabahkan generatePoint() untuk menghitung gaji yang akan didapatkan.
	public abstract int generatePoint();



}
