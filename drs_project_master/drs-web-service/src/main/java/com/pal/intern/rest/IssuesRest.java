package com.pal.intern.rest;

import com.pal.intern.domain.IssueMapper;
import com.pal.intern.service.IssueService;
import com.taskadapter.redmineapi.RedmineException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redmine/issues")
public class IssuesRest {

    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET)
    public ResponseEntity<IssueMapper> getIssueById(@PathVariable("issueId") int issueId) throws RedmineException {
        IssueMapper issueMapper = this.issueService.getIssueById(issueId);
        return new ResponseEntity<>(issueMapper, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getIssuesByProjectId(
            @RequestParam(value = "projectId", required = false) Integer projectId,
            @RequestParam(value = "offset", required = true, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = true, defaultValue = "25") int limit) throws RedmineException {
        Map<String, Object> result;
        if (projectId != null) {
            result = this.issueService.getListIssuesByProjectId(projectId, offset, limit);
        } else {
            result = this.issueService.getAllIssues(offset, limit);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getIssuesByProjectId(@RequestParam MultiValueMap<String,Object> otherParams) throws RedmineException {
        MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
        otherParams.forEach((k, v) -> {
            param.put(k, v);
        });
        return new ResponseEntity<>(this.issueService.getIssuesWithParam(param), HttpStatus.OK);
    }

}
