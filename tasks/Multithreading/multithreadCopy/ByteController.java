package multithreadCopy;

public class ByteController {

	private byte[] buffer;
	private ByteSender bs;
	private ByteReceiver br;
	private boolean flag = false;
	private int checkCntrl;

	public ByteController(ByteSender bs, ByteReceiver br) {
		super();
		this.bs = bs;
		this.br = br;
	}

	public ByteController() {
		super();
	}

	public int getCheckCntrl() {
		return checkCntrl;
	}

	public void setCheckCntrl(int checkCntrl) {
		this.checkCntrl = checkCntrl;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public ByteSender getBs() {
		return bs;
	}

	public void setBs(ByteSender bs) {
		this.bs = bs;
	}

	public ByteReceiver getBr() {
		return br;
	}

	public void setBr(ByteReceiver br) {
		this.br = br;
	}

	public synchronized byte[] getBuffer() {
		for (; flag == false;) {
			try {
//					System.out.println("Receiver Waiting");
//					System.out.println();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (flag == true) {
			flag = false;
//				System.out.println("Receiver Notifying");
//				System.out.println();
			notifyAll();
			return buffer;
		}
		return null;
	}

	public synchronized void setBuffer(byte[] buffer) {
		for (; flag == true;) {
			try {
//					System.out.println("Sender waiting");
//					System.out.println();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (flag == false) {
			flag = true;
//				System.out.println("Sender notifying");
//				System.out.println();
			notifyAll();
			this.buffer = buffer;
		}
	}

}
