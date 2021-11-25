package com.putoet.kata04;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class WeatherStats {
    private static final int DY_LEN = 3;
    private static final int MXT_LEN = 3;
    private static final int MNT_LEN = 4;
    private static final int AVT_LEN = 4;
    private static final int HDDAY_LEN = 6;
    private static final int AVDP_LEN = 5;
    private static final int HRP_LEN = 4;
    private static final int TPCPN_LEN = 5;
    private static final int WXTYPE_LEN = 6;
    private static final int PDIR_LEN = 4;
    private static final int AVSP_LEN = 4;
    private static final int DIR_LEN = 3;
    private static final int MXS_LEN = 3;
    private static final int SKYC_LEN = 3;
    private static final int MXR_LEN = 2;
    private static final int MNR_LEN = 2;
    private static final int AVSLP_LEN = 6;

    public final int dy;
    public final int mxt;
    public final int mnt;
    public final int avt;
    public final OptionalInt hdday;
    public final double avdp;
    public final OptionalInt hrp;
    public final double tpcpn;
    public final String wxtype;
    public final int pdir;
    public final double avsp;
    public final int dir;
    public final int msx;
    public final double skyc;
    public final int mxr;
    public final int mnr;
    public final double avslp;

    public WeatherStats(int dy, int mxt, int mnt, int avt, OptionalInt hdday, double avdp, OptionalInt hrp, double tpcpn, String wxtype, int pdir, double avsp, int dir, int msx, double skyc, int mxr, int mnr, double avslp) {
        this.dy = dy;
        this.mxt = mxt;
        this.mnt = mnt;
        this.avt = avt;
        this.hdday = hdday;
        this.avdp = avdp;
        this.hrp = hrp;
        this.tpcpn = tpcpn;
        this.wxtype = wxtype;
        this.pdir = pdir;
        this.avsp = avsp;
        this.dir = dir;
        this.msx = msx;
        this.skyc = skyc;
        this.mxr = mxr;
        this.mnr = mnr;
        this.avslp = avslp;
    }

    public static WeatherStats create(String line) {
        //    Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP
        //           1         2         3         4         5         6         7         8
        //  012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
        //     1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5
        //    17  81    57    69          51.7       0.00 T       260  9.1 270  29* 5.2  90 34 1012.5

        int start = 1;
        final int dy = Parser.asInt(line, start, start + DY_LEN);
        start += DY_LEN + 1;
        final int mxt = Parser.asInt(line, start, start + MXT_LEN);
        start += MXT_LEN + 2;
        final int mnt = Parser.asInt(line, start, start + MNT_LEN);
        start += MNT_LEN + 2;
        final int avt = Parser.asInt(line, start, start + AVT_LEN);
        start += AVT_LEN + 2;
        final OptionalInt hdday = Parser.asOptionalInt(line, start, start + HDDAY_LEN);
        start += HDDAY_LEN + 1;
        final double avdp = Parser.asDouble(line, start, start + AVDP_LEN);
        start += AVDP_LEN + 1;
        final OptionalInt hrp = Parser.asOptionalInt(line, start, start + HRP_LEN);
        start += HRP_LEN + 1;
        final double tpcpn = Parser.asDouble(line, start, start + TPCPN_LEN);
        start += TPCPN_LEN + 1;
        final String wxtype = Parser.asString(line, start, start + WXTYPE_LEN);
        start += WXTYPE_LEN + 1;
        final int pdir = Parser.asInt(line, start, start + PDIR_LEN);
        start += PDIR_LEN + 1;
        final double avsp = Parser.asDouble(line, start, start + AVSP_LEN);
        start += AVSP_LEN + 1;
        final int dir = Parser.asInt(line, start, start + DIR_LEN);
        start += DIR_LEN + 1;
        final int mxs = Parser.asInt(line, start, start + MXS_LEN);
        start += MXS_LEN + 2;
        final double skyc = Parser.asDouble(line, start, start + SKYC_LEN);
        start += SKYC_LEN + 2;
        final int mxr = Parser.asInt(line, start, start + MXR_LEN);
        start += MXR_LEN + 1;
        final int mnr = Parser.asInt(line, start, start + MNR_LEN);
        start += MNR_LEN + 1;
        final double avslp = Parser.asDouble(line, start, start + AVSLP_LEN);

        return new WeatherStats(dy, mxt, mnt, avt, hdday, avdp, hrp, tpcpn, wxtype, pdir, avsp, dir, mxs, skyc, mxr, mnr, avslp);
    }
}
