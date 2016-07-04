package com.doctor.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @description
 *
 * @author sdcuike
 *
 * @date 2016年7月4日 下午5:42:41
 */
public class ExceptionCatch {

	public static void main(String[] args) {
		try {

			try {
				int i = 1 / 0;
			} catch (Exception e) {
				throw new BusiException(e);
			}

		} catch (BusiException e) {

			Writer out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			e.printStackTrace(s);
			System.out.println(out.toString());
		}

		System.out.println("end============");
	}

	public static class BusiException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public BusiException() {
			super();
		}

		public BusiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public BusiException(String message, Throwable cause) {
			super(message, cause);
		}

		public BusiException(String message) {
			super(message);
		}

		public BusiException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}

	}

}
