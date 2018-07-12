
export const config = {
  server: {
    url: 'http://localhost:80/drs-web-service',
    delay: 0
  },
  mockRes: {
    status: false,
    issuesRes: false,
    projectRes: false
  },
  client: {
    remember: 'remember',
    userToken: 'uts',
    cardDefault: 'card-default',
    listTaskFork: 'listTaskFork',
    info: 'info'
  },
  roles: {
    admin: 'ROLE_ADMIN',
    user: 'ROLE_USER'
  }
};
