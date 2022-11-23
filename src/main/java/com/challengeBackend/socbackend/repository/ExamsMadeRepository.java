
package com.challengeBackend.socbackend.repository;
import com.challengeBackend.socbackend.model.ExamsMade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ExamsMadeRepository extends JpaRepository<ExamsMade, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from exams_made where employee_id = :employee_id", nativeQuery = true)
    public void deleteAllExamsmadeByEmployee_id(@Param("employee_id") Long employee_id);

    @Transactional
    @Query(value = "SELECT CASE WHEN EXISTS ( SELECT * FROM exams_made WHERE exam_id = :exam_id) THEN 'true' ELSE 'false' END", nativeQuery = true)
    public boolean findExam_idInExamsMade(@Param("exam_id") Long exam_id);

    @Transactional
    @Query(value = "SELECT CASE WHEN EXISTS ( SELECT * FROM exams_made WHERE exam_id = :exam_id AND employee_id = :employee_id AND CAST(exams_made_date as DATE) = CAST(:exams_made_date as DATE)) THEN 'true' ELSE 'false' END", nativeQuery = true)
    public boolean FindExamsMadeByAllFields(@Param("exam_id") Long exam_id, @Param("employee_id") Long employee_id, @Param("exams_made_date") Date exams_made_date);



}




