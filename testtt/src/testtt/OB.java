package testtt;

public class OB extends Pegawai implements Gaji{
	
	private int room;
	private int jamKerja;
	public int getJamKerja() {
		return jamKerja;
	}

	public void setJamKerja(int jamKerja) {
		this.jamKerja = jamKerja;
	}

	public OB(String name, String gender, String noHp, String email, String status, String alamat,String loyaltyCardID,Integer Gaji,int room,int jamKerja) {
		super(name, gender, noHp, email, status, alamat, loyaltyCardID, Gaji);
		// TODO Auto-generated constructor stub
		this.room = room;
		this.jamKerja = jamKerja;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public int generatePoint() {

		int currentPoint = (int)(Math.random()*(this.getName().length())) + 2;
		return currentPoint;
	
	}

	@Override
	public int dapatGaji() {
		int gaji = (int) (55.000 * this.generatePoint());
		System.out.println("Selamat anda mendapatkan gaji" + gaji);
		
		return gaji;
	}

	

}
