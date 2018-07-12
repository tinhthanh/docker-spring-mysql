package com.pal.intern.service;

import com.pal.intern.domain.GroupContactContent;
import java.util.List;
import java.util.Optional;

public interface GroupContactContentService {

    /**
     *
     * @param groupContactId
     * @param status status of group contact id (1: exist, 0:delete)
     * @return List
     */
    public List<GroupContactContent> getGroupContactContentByGroupContactId(int groupContactId, int status);

    /**
     *
     * @param contactEmail
     * @param contactAction (1:to 2:cc )
     * @param groupContactId
     * @return new entity id or -1
     */
    public int createGroupContactContent(String contactEmail, int contactAction, int groupContactId);

    public Optional<GroupContactContent> getGroupContactContentById(int groupContactContentId, int status);

    public Optional<GroupContactContent> getGroupContactContentByIdWithAllStatus(int groupContactContentId);

    public int updateGroupContactContent(GroupContactContent groupContactContent);

    public int deleteGroupContactContet(int groupContactContentId);

}
