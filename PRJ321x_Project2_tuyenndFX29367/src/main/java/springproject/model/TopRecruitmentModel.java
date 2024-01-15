package springproject.model;


import springproject.entity.Recruitment;

public class TopRecruitmentModel {
    private Recruitment recruitment;
    private long rank;

    public TopRecruitmentModel(Recruitment recruitment, long rank) {
        this.recruitment = recruitment;
        this.rank = rank;
    }

    public TopRecruitmentModel() {
    }


    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }
}
