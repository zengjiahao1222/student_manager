package com.zjh.service.impl;

import com.zjh.bean.Course;
import com.zjh.dao.CourseDao;
import com.zjh.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: abb
 * @DateTime: 2022-11-30 21:19
 * @Description: 课程实现类
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseDao courseDao;

    @Override
    public List<Course> findAllCourses() {
        return courseDao.selectCourses();
    }

    @Override
    public List<Course> findCoursesByPage(int page, int size) {
        int begin = (page - 1) * size;
        return courseDao.selectCoursesByLimit(begin,size);
    }

    @Override
    public int getCoursesCount() {
        return courseDao.getCoursesCount();
    }

    @Override
    public int deleteCourses(List<Course> courses) {
        return courseDao.deleteCourses(courses);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public List<Course> searchCourses(Integer page, Integer size, Map<String, Object> searchParam) {
        //在搜索的基础上添加2个参数
        searchParam.put("begin", (page - 1) * size);
        searchParam.put("size", size);
        return courseDao.searchCoursesByLimit(searchParam);
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return courseDao.getSearchCount(searchParam);
    }

    @Override
    public List<Course> findAllCoursesByTeacher(int tid) {
        return courseDao.selectCoursesByTeacher(tid);
    }
}
