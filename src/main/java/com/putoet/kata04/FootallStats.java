package com.putoet.kata04;

public class FootallStats {
    private static final int RANK_LEN = 2;
    private static final int TEAM_LEN = 15;
    private static final int PLAYED_LEN = 5;
    private static final int WON_LEN = 4;
    private static final int LEVELED_LEN = 3;
    private static final int DOWN_LEN = 4;
    private static final int GOALS_FOR_LEN = 3;
    private static final int GOALS_AGAINST_LEN = 5;
    private static final int POINTS_LEN = 2;

    public final int rank;
    public final String team;
    public final int played;
    public final int won;
    public final int leveled;
    public final int down;
    public final int goalsFor;
    public final int goalsAGainst;
    public final int points;

    public FootallStats(int rank, String team, int played, int won, int leveled, int down, int goalsFor, int goalsAGainst, int points) {
        this.rank = rank;
        this.team = team;
        this.played = played;
        this.won = won;
        this.leveled = leveled;
        this.down = down;
        this.goalsFor = goalsFor;
        this.goalsAGainst = goalsAGainst;
        this.points = points;
    }

    public static FootallStats create(String line) {
        //              1         2         3         4         5
        //    012345678901234567890123456789012345678901234567890123456789
        //           Team            P     W    L   D    F      A     Pts
        //        1. Arsenal         38    26   9   3    79  -  36    87

        int start = 3;
        final int rank = Parser.asInt(line, start, start + RANK_LEN);
        start += RANK_LEN + 2;
        final String team = Parser.asString(line, start, start + TEAM_LEN);
        start += TEAM_LEN + 1;
        final int played = Parser.asInt(line, start, start + PLAYED_LEN);
        start += PLAYED_LEN + 1;
        final int won = Parser.asInt(line, start, start + WON_LEN);
        start += WON_LEN + 1;
        final int leveled = Parser.asInt(line, start, start + LEVELED_LEN);
        start += LEVELED_LEN + 1;
        final int down = Parser.asInt(line, start, start + DOWN_LEN);
        start += WON_LEN + 1;
        final int goalsFor = Parser.asInt(line, start, start + GOALS_FOR_LEN);
        start += GOALS_FOR_LEN + 4;
        final int goalsAgainst = Parser.asInt(line, start, start + GOALS_AGAINST_LEN);
        start += GOALS_AGAINST_LEN + 1;
        final int points = Parser.asInt(line, start, start + POINTS_LEN);

        return new FootallStats(rank, team, played, won,leveled, down, goalsFor, goalsAgainst, points);
    }
}
