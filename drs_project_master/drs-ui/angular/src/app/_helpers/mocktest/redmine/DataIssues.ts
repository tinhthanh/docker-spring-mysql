
export class DataIssues {
   data: any[] ;
    constructor() {
     this.data = [
        {
          id: 28372,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 3,
            name: 'Patch'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 12557,
            name: 'Karel Pičman'
          },
          category: {
            id: 12,
            name: 'Translations'
          },
          subject: 'Czech localisation update',
          description: 'An untranslated text translated\r\nA typo fixed\r\nFormat unification',
          done_ratio: 0,
          created_on: '2018-03-19T13:50:08Z',
          updated_on: '2018-03-19T13:50:08Z'
        },
        {
          id: 28368,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 6,
            name: 'Urgent'
          },
          author: {
            id: 345655,
            name: 'pradeep pal'
          },
          subject: 'regarding watcher added in private project but not getting notification ',
          description: 'Hi \r\n   Created private project in redmine with role and permission called (viewownissue). when adding watchers , their are not getting notification nor email with ticket link \r\n\r\nCan anyone help with this ',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-19T08:27:39Z',
          updated_on: '2018-03-19T13:26:22Z'
        },
        {
          id: 28356,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 344895,
            name: 'simon_test test_simon'
          },
          category: {
            id: 10,
            name: 'UI'
          },
          subject: 'Jump to a project not showing whole project name',
          description: 'When having nested projects or longer project names the drop down menu "Jump to a project" does not resize to content and project names are trimmed at the end.\r\nIt is impossible to distinguish projects from each other if the difference between project names is only at the end.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-18T11:11:18Z',
          updated_on: '2018-03-18T11:11:18Z'
        },
        {
          id: 28354,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 67216,
            name: 'Fabián Rodríguez'
          },
          category: {
            id: 24,
            name: 'Documentation'
          },
          subject: 'Wrong menu option for enabling REST API in docs, can\'t fix it',
          description: 'It seems I can\'t edit this page:\r\n\r\n* http://www.redmine.org/projects/redmine/wiki/Rest_api\r\n\r\nIt indicates:\r\n\r\n> To enable the API-style authentication, you have to check Enable REST API in Administration -> Settings -> Authentication.\r\n\r\nIt should be:\r\n\r\n> To enable the API-style authentication, you have to check Enable REST API in Administration -> Settings -> *API*.\r\n\r\nIf there\'s a way to update my editing rights to fix this, I\'ll fix it.\r\n\r\nThank you!',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: ''
            }
          ],
          created_on: '2018-03-16T14:33:09Z',
          updated_on: '2018-03-16T14:33:09Z'
        },
        {
          id: 28352,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 345435,
            name: 'Oliwier Hołodowski'
          },
          category: {
            id: 2,
            name: 'Issues'
          },
          subject: 'Date custom field color',
          description: 'Hello, \r\nIs it possible to change color of date custom field in issue view if date expires? \r\nNormal color is black, when date expire change text color to red.\r\n\r\nRegards,\r\ntrumex',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-16T08:28:41Z',
          updated_on: '2018-03-17T06:12:41Z'
        },
        {
          id: 28343,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 5,
            name: 'High'
          },
          author: {
            id: 49905,
            name: 'Brice Beaumesnil'
          },
          category: {
            id: 56,
            name: 'Issues filter'
          },
          subject: 'Error to save custom query',
          description: 'When i want to save a custom query, the sort_criteria saved in database is wrong.\r\nAnd i have this error :\r\n\r\nActionView::Template::Error (undefined method `+\' for nil:NilClass):\r\n    1: <%= hidden_field_tag \'set_filter\', \'1\' %>\r\n    2: <%= hidden_field_tag \'type\', @query.type, :disabled => true, :id => \'query_type\' %>\r\n    3: <%= query_hidden_sort_tag(@query) %>\r\n    4:\r\n    5: <div id="query_form_with_buttons" class="hide-when-print">\r\n    6: <div id="query_form_content">\r\n  lib/redmine/sort_criteria.rb:35:in `block in to_param\'\r\n  lib/redmine/sort_criteria.rb:35:in `collect\'\r\n  lib/redmine/sort_criteria.rb:35:in `to_param\'\r\n  app/helpers/queries_helper.rb:372:in `query_hidden_sort_tag\'\r\n  app/views/queries/_query_form.html.erb:3:in `_3dab2d6c79ffe592a7e685bf7851a687\'\r\n  app/views/issues/index.html.erb:11:in `block in _f2c5feeaee6cbb1d8e600dad9df23bd6\'\r\n  app/views/issues/index.html.erb:10:in `_f2c5feeaee6cbb1d8e600dad9df23bd6\'\r\n  app/controllers/issues_controller.rb:51:in `block (2 levels) in index\'\r\n  app/controllers/issues_controller.rb:46:in `index\'\r\n  lib/redmine/sudo_mode.rb:63:in `sudo_mode\'\r\n\r\nThe value used to be : --- []\r\nbut i have :\r\n---\r\n- - \r\n  - asc\r\n- - \r\n  - asc\r\n- - \r\n  - asc\r\n\r\nOr if i select just one sort item :\r\n---\r\n- - id\r\n  - desc\r\n- - \r\n  - asc\r\n- - \r\n  - asc\r\n',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-15T09:50:00Z',
          updated_on: '2018-03-17T06:17:48Z'
        },
        {
          id: 28340,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 3,
            name: 'Low'
          },
          author: {
            id: 344361,
            name: 'Grigoriy Vasilchenko'
          },
          subject: 'Plugin Tutorial doesn\'t work',
          description: 'Ruby 2.4.3\r\nRails 4.2.8\r\nRedmine 3.4.4\r\n\r\nHello.\r\n\r\nI tried to create plugin using step by step plugin tutorial and there were some problems. I had to make several corrections to make plugin working. Since I\'m newbie to ruby, rails, redmine - there is no confidence in rightness of my adjustments.\r\n\r\nParagraph "Extending the project menu":\r\n1. I replaced @@polls = Poll.find(:all)@ with @@polls = Poll.all@\r\n<pre>\r\ndef index\r\n  @project = Project.find(params[:project_id])\r\n  @polls = Poll.find(:all) # @project.polls\r\nend\r\n</pre>\r\n2. After clicking \'Yes\' or \'No\' error page was displaying. To solve this I  modified method \'vote\' (\'redirect_to\' invocation) to:\r\n<pre>\r\n  def vote\t\r\n    poll = Poll.find(params[:id])\r\n    poll.vote(params[:answer])\r\n    if poll.save\r\n      flash[:notice] = \'Vote saved.\'\r\n    end\r\n\t\t\r\n    redirect_to :action => \'index\', :project_id => params[:project_id]\r\n  end\r\n</pre>\r\nand added \'project_id\' parameter in \'link_to\' index.html.erb: \r\n<pre>\r\n<% @polls.each do |poll| %>\r\n\t<p>\r\n\t\t<%= poll.question %>?\r\n\t\t<%= link_to \'Yes\', { :action => \'vote\', :id => poll[:id], :answer => \'yes\', :project_id => @project }, :method => :post %> <%= poll.yes %> /\r\n\t\t<%= link_to \'No\', { :action => \'vote\', :id => poll[:id], :answer => \'no\', :project_id => @project }, :method => :post %> <%= poll.no %>\r\n\t</p>\r\n<% end %>\r\n</pre>',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-15T08:00:48Z',
          updated_on: '2018-03-15T08:00:48Z'
        },
        {
          id: 28339,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 345315,
            name: 'sergio .'
          },
          category: {
            id: 10,
            name: 'UI'
          },
          subject: 'Some parts are unseen with dark theme.',
          description: 'I\'v just set dark theme for GTK:\r\n\r\nexport GTK_THEME=Adwaita:dark\r\n\r\nand firefox uses it.\r\n\r\nSo by default all backgroud is dark and font is light. And it\'s OK while you changes both values (fg and bg) together and avoid change only one value. But really if your style is Light you should define all colors and avoid defaults!',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-15T01:11:37Z',
          updated_on: '2018-03-15T01:13:41Z'
        },
        {
          id: 28338,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 123866,
            name: 'Stephane Evr'
          },
          subject: 'Make Redmine Email Delivery compatible with ActiveJob',
          description: 'I have started implementing a Resque backend for Redmine (with the redmine_resque plugin) in order to process some background jobs as well as emails. The following is about what I had to do in order to make the email delivery work properly. *I have as well found some bugs which can be fixed easily*.\r\n\r\n* In @config/initializers/10-patches.rb@\r\n\r\n<pre><code class="ruby">\r\n# #deliver is deprecated in Rails 4.2\r\n# Prevents massive deprecation warnings\r\nmodule ActionMailer\r\n  class MessageDelivery < Delegator\r\n    def deliver\r\n      deliver_later # instead of deliver_now\r\n    end\r\n  end\r\nend\r\n</code></pre>\r\n\r\n* In @config/configuration.yml@\r\n\r\nuse SMTP instead of ASYNC SMTP, no need to pass the email processing to a thread.\r\n\r\n\r\n\r\nThe emails should then be processed by the background job backend.\r\n\r\nI however ran into some issues, where some notification emails would cause the following error:\r\n\r\n<pre>\r\nActiveJob::SerializationError: Unsupported argument type: Symbol\r\n</pre>\r\n\r\nI found that this was caused by the following arguments being passed from the @Mailer@ model to @ActiveJob@ (there are several places in the code):\r\n\r\n\r\n<pre><code class="ruby">\r\n# Notifies user that his password was updated\r\n  def self.password_updated(user)\r\n    return if user.admin? && user.login == \'admin\' && user.mail == \'admin@example.net\'\r\n\r\n    security_notification(user,\r\n      message: :mail_body_password_updated, # <--- THIS ARG\r\n      title: :button_change_password, # <--- THIS ARG\r\n      url: {controller: \'my\', action: \'password\'}\r\n    ).deliver\r\n  end\r\n</code></pre>\r\n\r\nWhich needs to be replaced with:\r\n\r\n<pre><code class="ruby">\r\n# Notifies user that his password was updated\r\n  def self.password_updated(user)\r\n    return if user.admin? && user.login == \'admin\' && user.mail == \'admin@example.net\'\r\n\r\n    security_notification(user,\r\n      message: "mail_body_password_updated", # <--- THIS ARG\r\n      title: "button_change_password", # <--- THIS ARG\r\n      url: {controller: \'my\', action: \'password\'}\r\n    ).deliver\r\n  end\r\n</code></pre>\r\n\r\nAs ActiveJob is not able to process parameters as symbols.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-14T15:49:25Z',
          updated_on: '2018-03-14T15:49:25Z'
        },
        {
          id: 28331,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 259873,
            name: 'Mizuki ISHIKAWA'
          },
          category: {
            id: 26,
            name: 'Text formatting'
          },
          subject: 'Paragraph mark is not displayed when h4, h5, and h6',
          description: 'When you enter "h1, h2, h3" paragraph begins from there, and paragraph mark (¶) will be displayed by mouse hover.\r\n!{width: 50%; border:1px solid #ccc}paragraph.png!\r\nIn case of "h4, h5, h6" There is a paragraph mark, but it is not displayed because there is no setting to display.\r\n\r\nAs "h4, h5, h6" is also the beginning of a paragraph like "h1, h2, h3", a paragraph mark should be displayed.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: ''
            }
          ],
          created_on: '2018-03-14T06:32:48Z',
          updated_on: '2018-03-14T06:34:40Z'
        },
        {
          id: 28330,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 259873,
            name: 'Mizuki ISHIKAWA'
          },
          category: {
            id: 10,
            name: 'UI'
          },
          subject: 'The link to the wiki section should highlight the linked section as well as the issue\'s note',
          description: '!{width: 70%; border:1px solid #ccc}highlighted_note.png!\r\nIn the issue, linked notes are visually emphasized.\r\nI often use the link to the wiki section so I would like the section to be emphasized just like Issue.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-14T00:29:23Z',
          updated_on: '2018-03-14T02:41:16Z'
        },
        {
          id: 28328,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 48411,
            name: 'Wojtek …'
          },
          category: {
            id: 17,
            name: 'Permissions and roles'
          },
          subject: '"Manage files" permission should be split to add and remove',
          description: 'Currently we only have following permission control over files (and I assume attachments)\r\n* @View files@\r\n* @Manage files@\r\n\r\nI propose to split the latter into (at least) two - separately @add@ and @remove@, to basically prevent users from deleting attachments/content.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-13T16:48:36Z',
          updated_on: '2018-03-14T01:51:04Z'
        },
        {
          id: 28327,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 159292,
            name: 'Shreyas Moolya'
          },
          category: {
            id: 50,
            name: 'Activity view'
          },
          subject: 'Use of \'Feedback\' term instead of \'Notes\' in Edit-event',
          description: 'Hi,\r\n\r\nI have been using redmine since last 2 years. Redmine solves a lot of problems in a very organized manner so I thought contribution to this community would be a value addition for me. \r\n\r\nThe term \'notes\' in the edit section does provide me a beautiful functionality of entering my queries related to development. But somehow this term does not signify what the user wants to highlight.\r\nThe term \'notes\' is being used where the user wants to highlight any specific point but since the functionality also serves us with a feedback loop for the \'Author\' a change in the term is necessary. Will it be right to use \'Feedback\' or \'Feeds\' as the term instead of \'notes\'.\r\nAlso if I was a beta tester this point would definitely be highlighted. There is a possibility I may be wrong. The issue is debatable. Suggestions are appreciated.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-13T11:48:50Z',
          updated_on: '2018-03-13T11:48:50Z'
        },
        {
          id: 28325,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 16810,
            name: 'Reidar M. Tronstad'
          },
          category: {
            id: 53,
            name: 'Performance'
          },
          subject: 'Copy of project fails',
          description: 'We use projects as templates for new projects, new projects are created by copying the template project.\r\nSome times the copy terminates but it takes very long > 6 hours blocking Redmine for other updates.\r\nUsually the copy fails without copying any issues.\r\nOur project is not extremely big about 5000-6000 issues with relations and attached files.\r\n\r\nWe can copy using export/import losing the attached files.\r\n\r\nIs this a bug?\r\n\r\nThank you for a great product.\r\nRegards',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '133'
            }
          ],
          created_on: '2018-03-12T16:11:24Z',
          updated_on: '2018-03-12T16:11:24Z'
        },
        {
          id: 28322,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 14446,
            name: 'Gregor Schmidt'
          },
          category: {
            id: 3,
            name: 'SCM'
          },
          fixed_version: {
            id: 33,
            name: 'Candidate for next minor release'
          },
          subject: 'Commit messages referencing issues should stop at line breaks',
          description: 'When referencing an issue via commit message, the matching should stop at line breaks. Otherwise, unexpected things may happen. \r\n\r\nE.g given the following commit message:\r\n\r\n<pre>\r\nInitial version of Feature #123\r\n\r\nIncludes the following changes:\r\n\r\n#124 some UI fixes\r\n#125 still work in progress\r\n</pre>\r\n\r\nthe current implementation will mark @#125@ as fixed. I think, this is unexpected.\r\n\r\nI\'ve attached a patch, which replaces all @\\s@ with @[[:blank:]]@ in the relevant regular expressions. Those matchers are equivalent, but @[[:blank:]]@ does not match @\\r\\n@. I\'ve also added a test.\r\n\r\nThis bug was identified by Holger Just from Planio.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: ''
            }
          ],
          created_on: '2018-03-12T08:53:46Z',
          updated_on: '2018-03-12T13:28:37Z'
        },
        {
          id: 28321,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 3,
            name: 'Patch'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 332,
            name: 'Go MAEDA'
          },
          category: {
            id: 12,
            name: 'Translations'
          },
          fixed_version: {
            id: 99,
            name: '4.0.0'
          },
          subject: 'Change Japanese translation for "in use"',
          description: 'I suggest improving Japanese translation for "X is in use", to change from "使用されています" to "使用中です". Both two expression have almost the same meaning, but "使用中です" is shorter and more natural.',
          done_ratio: 0,
          created_on: '2018-03-12T06:03:18Z',
          updated_on: '2018-03-14T01:31:24Z'
        },
        {
          id: 28312,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 3,
            name: 'Low'
          },
          author: {
            id: 319938,
            name: 'Colin \'t Hart'
          },
          subject: 'Option to automatically add user as watcher to an issue if they edit an issue they\'re not currently involved with',
          description: 'We occasionally get users updating issues that they didn\'t create, nor are they watching.\r\n\r\nWhat happens then is they don\'t get email -- neither for the update they made, nor for any future updates.\r\n\r\nWhat we would like is to automatically have such a user added as watcher to the issue.\r\n\r\nSuggest that this be made an option, with it default to "off" for old behaviour.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-09T10:46:37Z',
          updated_on: '2018-03-09T10:46:37Z'
        },
        {
          id: 28309,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 159877,
            name: 'Eduard Panov'
          },
          category: {
            id: 30,
            name: 'Code cleanup/refactoring'
          },
          subject: 'Error when query filter model inherited from other class which inherited from Query',
          description: 'We have a plugin, where: @MyPluginModelQuery < MyCustomClassQuery < Query@\r\nAfter redmine update 3.4.4 have a string https://github.com/redmine/redmine/commit/fd3c08aaa107e2c5a412a06aea6890b147e46aaf#diff-0fd59f260b10d1cfcf0c5695de8a99e6R90\r\nwhere call @Query.get_subclass@\r\nwhere a condition @subclasses.include? klass@\r\n\r\nAnd if my MyPluginModelQuery not a direct children of Query error raised.\r\n\r\nMy suggest: improve string https://github.com/redmine/redmine/blob/master/lib/redmine/subclass_factory.rb#L32 for support children\'s any deep, for example @unless  klass < self@',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-08T11:55:06Z',
          updated_on: '2018-03-08T11:55:06Z'
        },
        {
          id: 28308,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 160151,
            name: 'Randa Bustami'
          },
          category: {
            id: 2,
            name: 'Issues'
          },
          subject: 'validation at date of spent time',
          description: 'can we add validation of spent time for the year and make it start from reasonable year like 2YYY where it accept 0003 \r\nthe user insert his data but its outside  and duration we may search or filter\r\n\r\n',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-08T11:14:30Z',
          updated_on: '2018-03-08T11:14:30Z'
        },
        {
          id: 28304,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 1565,
            name: 'Mischa The Evil'
          },
          category: {
            id: 30,
            name: 'Code cleanup/refactoring'
          },
          subject: 'Move tests related to textile syntax to dedicated TextileFormatterTest class',
          description: '_Originating from #28119#note-2 and #28207._\r\n\r\nWhile looking at those two issues, the question of \'how many other textile syntax tests are there remaining, lurking outside of source:/trunk/test/unit/lib/redmine/wiki_formatting/textile_formatter_test.rb and what do we want to do with them?\' came up...\r\nThe answer to the first part would be \'several\'. My answer to the second part of the question would be \'move them to the dedicated TextileFormatterTest class\'.\r\n',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: ''
            }
          ],
          created_on: '2018-03-07T08:24:36Z',
          updated_on: '2018-03-07T08:24:36Z'
        },
        {
          id: 28303,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 6,
            name: 'Urgent'
          },
          author: {
            id: 204546,
            name: 'PJ Legendre'
          },
          category: {
            id: 24,
            name: 'Documentation'
          },
          subject: 'Documentation needs tutorial for installing Redmine 3.4 with Apache on Ubuntu 16.04 ',
          description: 'I have spend 12 hours attempting this and have gotten nowhere. I see reason for it to be this difficult to install Redmine. :/\r\n\r\nI have tried various other tutorials that use Nginx, other OS versions, etc. But it seems they\'re too different to actually be of use.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '134'
            }
          ],
          created_on: '2018-03-07T01:51:58Z',
          updated_on: '2018-03-07T01:51:58Z'
        },
        {
          id: 28302,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 1,
            name: 'Defect'
          },
          status: {
            id: 9,
            name: 'Confirmed'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 3866,
            name: 'Felix Schäfer'
          },
          category: {
            id: 9,
            name: 'Email notifications'
          },
          fixed_version: {
            id: 138,
            name: '3.3.7'
          },
          subject: 'Security notification when changing password on password forgotten is empty',
          description: 'Currently the "User" and "IP address" fields in security notification emails sent when changing a password using the forgotten password feature are empty.\r\n\r\nJan had already proposed a patch for this in the original security notification issue #21421#note-15, but it seems to have been overlooked. If this was intentionally left out, I am sorry to bother and I suggest adapting the email to not include the fields at all instead of leaving them blank.\r\n\r\nI have updated Jans patch against master and I will attach it to this issue.',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            },
            {
              id: 4,
              name: 'Affected version',
              value: '110'
            }
          ],
          created_on: '2018-03-06T21:16:39Z',
          updated_on: '2018-03-07T08:17:15Z'
        },
        {
          id: 28299,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 130529,
            name: 'César Lizurey'
          },
          category: {
            id: 32,
            name: 'REST API'
          },
          subject: 'Get issue by group',
          description: 'Hi,\r\nFor the moment we can only fetch issues assigned to a particular member. It would be great to fetch issues assigned to groups of the user:\r\n\r\nGET /issues.xml?assigned_to_id=6&include=groups\r\n\r\nThanks',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-06T06:45:28Z',
          updated_on: '2018-03-06T06:45:28Z'
        },
        {
          id: 28298,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 2,
            name: 'Feature'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 130529,
            name: 'César Lizurey'
          },
          category: {
            id: 32,
            name: 'REST API'
          },
          subject: 'Get issues by login',
          description: 'Hi,\r\nIt would be great to fetch issues by login:\r\nGET /issues.xml?assigned_to_login=my.login\r\n\r\nFor the moment we can only fetch by id.\r\nThanks',
          done_ratio: 0,
          custom_fields: [
            {
              id: 2,
              name: 'Resolution',
              value: ''
            }
          ],
          created_on: '2018-03-06T06:43:35Z',
          updated_on: '2018-03-06T06:43:35Z'
        },
        {
          id: 28295,
          project: {
            id: 1,
            name: 'Redmine'
          },
          tracker: {
            id: 3,
            name: 'Patch'
          },
          status: {
            id: 1,
            name: 'New'
          },
          priority: {
            id: 4,
            name: 'Normal'
          },
          author: {
            id: 14446,
            name: 'Gregor Schmidt'
          },
          category: {
            id: 19,
            name: 'Attachments'
          },
          fixed_version: {
            id: 32,
            name: 'Candidate for next major release'
          },
          subject: 'Show name changes in diff preview',
          description: 'When previewing uploaded diff/patch files, which contains renames, Redmine will always show the new file name in the diff preview. This can be misleading, since it would not show that the old file was removed.\r\n\r\nThe attached patch keeps track of the previous file name and shows the additional information in the UI.\r\n\r\n!Screen Shot 2018-03-05 at 14.48.00.png!\r\n\r\nPlease note, this patch was tested with/developed for git\'s patch files. Also, pure renames (without file modifications) will not be visible -- just like they are today.',
          done_ratio: 0,
          created_on: '2018-03-05T13:59:09Z',
          updated_on: '2018-03-14T01:42:26Z'
        }
      ];
    }

} 