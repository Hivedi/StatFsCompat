package com.hivedi.statfscompat;

import android.os.Build;
import android.os.StatFs;

import java.io.File;

/**
 * Created by Hivedi2 on 2015-11-24.
 *
 */
public class StatFsCompat {

	public static final long STAT_FS_ERROR = -1L;

	@SuppressWarnings("deprecation")
	public static long getStatFsTotal(File f) {
		try {
			StatFs statFs = new StatFs(f.getAbsolutePath());
			if (Build.VERSION.SDK_INT >= 18) {
				return statFs.getTotalBytes();
			} else {
				return statFs.getBlockCount() * statFs.getBlockSize();
			}
		} catch (IllegalArgumentException e) {
			return STAT_FS_ERROR;
		}
	}

	@SuppressWarnings("deprecation")
	public static long getStatFsFree(File f) {
		try {
			StatFs statFs = new StatFs(f.getAbsolutePath());
			if (Build.VERSION.SDK_INT >= 18) {
				return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
			} else {
				return statFs.getAvailableBlocks() * (long) statFs.getBlockSize();
			}
		} catch (IllegalArgumentException e) {
			return STAT_FS_ERROR;
		}
	}

}
