package in.rajarshichakrabarty.db.dao;

import in.rajarshichakrabarty.db.model.QrCodeImage;

public interface QrCodeImageDao extends Dao<QrCodeImage, Integer> {

	void saveQRCode(QrCodeImage qrCodeImage);

	QrCodeImage getQRCode(String url);

}
