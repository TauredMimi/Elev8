class courses {
    private String courseCode;
    private int courseUnits;
    private int score;

    public courses(String courseCode, int courseUnits, int score) {
        this.courseCode = courseCode;
        this.courseUnits = courseUnits;
        this.score = score;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCourseUnits() {
        return courseUnits;
    }

    public int getScore() {
        return score;
    }
}