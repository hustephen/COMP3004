package com.example.androidtemplate.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ByteUtil {
	/**
	 * 将int类型的数据转换为byte数组 （长度为4）原理：将int数据中的四个byte取出，分别存储
	 * 
	 * @param n
	 *            int数据
	 * @return 生成的byte数组
	 */
	public static byte[] intToBytes4(int n) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (n >> (24 - i * 8));
		}
		return b;
	}

	/**
	 * 将byte数组(长度为4)转换为int数据
	 * 
	 * @param b
	 *            字节数组
	 * @return 生成的int数据
	 */
	public static int byte4ToInt(byte[] b) {
		return (((int) b[0]) << 24) + (((int) b[1]) << 16) + (((int) b[2]) << 8) + b[3];
	}
	
	/**
	 * 将byte数组(长度为2)转换为int数据
	 * @param b
	 * @return
	 */
	public static int byte2ToInt(byte[] b) {
		return (((int) b[0]) << 8) + b[1];
	}


	public static byte[] getBytes(int value) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		byteBuffer.putInt(value);
		return byteBuffer.array();
	}

	public static int parseBytesToInt32(byte[] value) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(value);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		return byteBuffer.asIntBuffer().get();
	}

	public static byte[] gzipCompressToBytes(byte[] content) {
		byte[] gzipContent = null;

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
			gzipOutputStream.write(content);
			gzipOutputStream.close();

			gzipContent = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			
		}
		return gzipContent;
	}

	public static byte[] unGzipFromStream(InputStream inputStream, int length) {
		byte[] unGzipContent = null;

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream, length);
			byte[] buffer = new byte[2048];
			int n = 0;
			while ((n = gZIPInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, n);
			}
			//			gZIPInputStream.close();

			unGzipContent = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			
		}

		return unGzipContent;
	}

	public static String gzipCompressToString(String string) {
		String gzipContent = null;
		if (string == null || string.length() == 0) {
			return gzipContent;
		}

		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
			gZIPOutputStream.write(string.getBytes("utf-8"));
			gZIPOutputStream.close();

			gzipContent = new String(byteArrayOutputStream.toByteArray(), "iso-8859-1");
		} catch (IOException e) {
			// ignore
			//			log.error(e.getMessage(), e);
		}

		return gzipContent;
	}

	public static String unGzipFromString(String string) {
		String unGzipContent = null;
		if (string == null || string.length() == 0) {
			return unGzipContent;
		}

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ByteArrayInputStream byteArrayInputStream;
		GZIPInputStream gZIPInputStream;
		try {
			byteArrayInputStream = new ByteArrayInputStream(string.getBytes("iso-8859-1"));
			gZIPInputStream = new GZIPInputStream(byteArrayInputStream);

			byte[] buffer = new byte[2048];
			int n;
			while ((n = gZIPInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, n);
			}
			unGzipContent = new String(byteArrayOutputStream.toByteArray(), "utf-8");
		} catch (IOException e) {
			// ignore
			//			log.error(e.getMessage(), e);
		}

		return unGzipContent;
	}
}
