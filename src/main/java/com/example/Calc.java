package com.example;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Component
@Path("calc")
public class Calc {

    // curl -H "Accept:application/json" -v "http://localhost:8080/calc?left=100&right=200"
    @GET
    public Result calc(@QueryParam("left") int left, @QueryParam("right") int right) {
        return new Result(left, right, left + right);
    }

    public static class Result {
        private final int left;
        private final int right;
        private final long answer;

        public Result(int left, int right, long answer) {
            this.left = left;
            this.right = right;
            this.answer = answer;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public long getAnswer() {
            return answer;
        }
    }
}
