package com.etienne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFiles {

	public static void main(String[] args) {

		try (FileOutputStream binFile = new FileOutputStream("filesoldjava11/data.dat");
			 FileChannel binChannel = binFile.getChannel()) {

			ByteBuffer buffer = ByteBuffer.allocate(100);

			/*
			byte[] outputBytes = "Hello World!".getBytes();
			byte[] outputBytes2 = "Nice to meet you".getBytes();
			buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
			buffer.flip();
			*/



//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

			byte[] outputBytes = "Hello World!".getBytes();
			byte[] outputBytes2 = "Nice to meet you".getBytes();
			buffer.put(outputBytes);
			long int1Pos = outputBytes.length;
			buffer.putInt(245);
			long int2Pos = int1Pos + Integer.BYTES;
			buffer.putInt(-98765);
			buffer.put(outputBytes2);
			long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
			buffer.putInt(1000);
			buffer.flip();

			binChannel.write(buffer);

			RandomAccessFile ra = new RandomAccessFile("filesoldjava11/data.dat", "rwd");
			FileChannel channel = ra.getChannel();

			ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
			channel.position(int3Pos);
			channel.read(readBuffer);
			readBuffer.flip();

			System.out.println("int3 = " + readBuffer.getInt());
			readBuffer.flip();
			channel.position(int2Pos);
			channel.read(readBuffer);
			readBuffer.flip();

			System.out.println("int2 = " + readBuffer.getInt());
			readBuffer.flip();
			channel.position(int1Pos);
			channel.read(readBuffer);
			readBuffer.flip();

			System.out.println("int1 = " + readBuffer.getInt());

			RandomAccessFile copyFile = new RandomAccessFile("filesoldjava11/datacopy.dat", "rw");
			FileChannel copyChannel = copyFile.getChannel();
			channel.position(0);
			// long numTransfereed = copyChannel.transferFrom(channel, 0, channel.size());
			long numTransfereed = copyChannel.transferTo(0, channel.size(), copyChannel);
			System.out.println("Num transferred = " + numTransfereed);

			channel.close();
			ra.close();
			copyChannel.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
