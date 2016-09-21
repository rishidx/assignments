package in.rajarshichakrabarty.db.dao;

import in.rajarshichakrabarty.db.model.QrCodeImage;

public class QrCodeImageDaoImpl extends DaoImpl<QrCodeImage, Integer> implements QrCodeImageDao {

	public QrCodeImageDaoImpl() {
		super(QrCodeImage.class);
	}

	@Override
	public void saveQRCode(QrCodeImage qrCodeImage) {
		
	}

	@Override
	public QrCodeImage getQRCode(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
