
export const data =  [
    {
      id: 13,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: null,
        name: null
      },
      listOfWatcher: [],
      subject: 'Accept groups in project\'s default assignee',
      description: 'Project\'s default assignee which has been implemented in #482 does not accept groups even if the "Allow issue assignment to groups" is set to true. I have been using Redmine for customer support and I want to assign issues to the support team',
      doneRatio: 0,
      createdOn: 1524241648000,
      updatedOn: 1524241648000,
      closedOn: null
    },
    {
      id: 12,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 1,
        name: 'Alex Admin'
      },
      listOfWatcher: [],
      subject: 'Error to save custom query',
      description: '"When i want to save a custom query, the sort_criteria saved in database is wrong. And i have this error : <pre> ActionView::Template::Error (undefined method `+\' for nil:NilClass): 1: <%= hidden_field_tag \'set_filter\', \'1\' %> 2: <%= hidden_field_tag \'type\', @query.type, :disabled => true, :id => \'query_type\' %> 3: <%= query_hidden_sort_tag(@query) %> 4: 5: <div id="query_form_with_buttons" class="hide-when-print"> 6: <div id="query_form_content"> lib/redmine/sort_criteria.rb:35:in `block in to_param\' lib/redmine/sort_criteria.rb:35:in `collect\' lib/redmine/sort_criteria.rb:35:in `to_param\' app/helpers/queries_helper.rb:372:in `query_hidden_sort_tag\' app/views/queries/_query_form.html.erb:3:in `_3dab2d6c79ffe592a7e685bf7851a687\' app/views/issues/index.html.erb:11:in `block in _f2c5feeaee6cbb1d8e600dad9df23bd6\' app/views/issues/index.html.erb:10:in `_f2c5feeaee6cbb1d8e600dad9df23bd6\' app/controllers/issues_controller.rb:51:in `block (2 levels) in index\' app/controllers/issues_controller.rb:46:in `index\' lib/redmine/sudo_mode.rb:63:in `sudo_mode\' </pre> The value used to be : @--- []@ but i have : <pre> --- - - - asc - - - asc - - - asc </pre> Or if i select just one sort item : <pre> --- - - id - desc - - - asc - - - asc </pre>',
      doneRatio: 0,
      createdOn: 1523158477000,
      updatedOn: 1523158477000,
      closedOn: null
    },
    {
      id: 11,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 1,
        name: 'Alex Admin'
      },
      listOfWatcher: [],
      subject: 'Date custom field color',
      description: 'Hello, Is it possible to change color of date custom field in issue view if date expires? Normal color is black, when date expire change text color to red. Regards, trumex',
      doneRatio: 0,
      createdOn: 1523158461000,
      updatedOn: 1523158461000,
      closedOn: null
    },
    {
      id: 10,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: null,
        name: null
      },
      listOfWatcher: [],
      subject: 'Jump to a project not showing whole project name',
      description: 'When having nested projects or longer project names the drop down menu "Jump to a project" does not resize to content and project names are trimmed at the end. It is impossible to distinguish projects from each other if the difference between project names is only at the end.',
      doneRatio: 0,
      createdOn: 1523158418000,
      updatedOn: 1523158418000,
      closedOn: null
    },
    {
      id: 9,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 1,
        name: 'Alex Admin'
      },
      listOfWatcher: [],
      subject: 'Czech localisation update',
      description: 'An untranslated text translated A typo fixed Format unification',
      doneRatio: 0,
      createdOn: 1523158401000,
      updatedOn: 1523158401000,
      closedOn: null
    },
    {
      id: 8,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 1,
        name: 'Alex Admin'
      },
      listOfWatcher: [],
      subject: 'custom field filter on issues list requires other filters to be respected',
      description: 'Custom field filters included into _issues_ REST api request are not working as expected. <pre> /issues.json?cf_1=1234 </pre> will return all issues not only those with the value @1234@ in the custom field with id 1. That is the filter is completely ignored. The only case in which custom field filters are working is when the query string includes a @project_id@ filter. <pre> /issues.json?cf_1=1234&project_id=1 </pre> This works. Only issues with the custom field 1 containing the value @1234@ are being returned. In contrast to this adding the @status_id@ is not causing the custom field filter to be respected',
      doneRatio: 0,
      createdOn: 1523158380000,
      updatedOn: 1523158380000,
      closedOn: null
    },
    {
      id: 7,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 3,
        name: 'High'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 1,
        name: 'Alex Admin'
      },
      listOfWatcher: [],
      subject: 'RFE: System-configurable options to control email rejection criteria',
      description: 'Some common causes for emails to be rejected by the scraping process: * from emission address * characters outside of the utf8 character set (#21398) * from email addresses associated with a locked account * subject lines that appear to match issue responses (#25473) Most of these are understandable, but it would be useful to have the option to override the rejection behavior and allow a new issue to be created from the email. This could either be a setting available within the Admin panel UI or at the file-system level in a configuration file. This is particularly useful where Redmine is used as a Help Desk platform where it may be important to relax specific criteria for accepting email (e.g., accept an email from a locked account, but from "anonymous"). Thank you for your consideration.',
      doneRatio: 0,
      createdOn: 1523158349000,
      updatedOn: 1523158349000,
      closedOn: null
    },
    {
      id: 6,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 6,
        name: 'ginny huynh'
      },
      listOfWatcher: [],
      subject: 'default assignment based on tracker',
      description: 'Hi, It would be very helpful to have predefined (default) assignee\'s for certain trackers. The fields can be customized :) and defaults for custom fields can be defined, but default assignee\'s per tracker unfortunately not. Thanks. Ruud',
      doneRatio: 0,
      createdOn: 1523153186000,
      updatedOn: 1524245177000,
      closedOn: null
    },
    {
      id: 5,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: 6,
        name: 'ginny huynh'
      },
      listOfWatcher: [],
      subject: 'Syntax highlighter does not work if language name is single-quoted',
      description: 'Please see the screenshot below. Syntax highlighter does not work if "Text formatting" is set to "Textile" and the language name is enclosed by single quotation marks. The Textile formatter should accept single quotation marks as well as double quotation marks. !{width: 252px; border: 1px solid #ccc;}.screenshot@2x.png!',
      doneRatio: 0,
      createdOn: 1523153164000,
      updatedOn: 1523153164000,
      closedOn: null
    },
    {
      id: 4,
      project: {
        id: 1,
        name: 'Remine Api'
      },
      tracker: {
        id: 1,
        name: 'Bug'
      },
      status: {
        id: 1,
        name: 'New'
      },
      priority: {
        id: 2,
        name: 'Normal'
      },
      author: {
        id: 1,
        name: 'Alex Admin'
      },
      assignee: {
        id: null,
        name: null
      },
      listOfWatcher: [],
      subject: 'Make "Subtasks" section headers a links to issue query',
      description: 'The header on issue page "Subtasks" list issues, in some way, with some defaults columns. It would be very helpful if the section header could be clickable link to issue queries showing those issues: - Subtasks should link to issue query with filter parent "contains" the issue number It would be good to have same thing for "Related issues" but there seems to be no filter allowing to show all types of relations.',
      doneRatio: 0,
      createdOn: 1523153137000,
      updatedOn: 1523153137000,
      closedOn: null
    }
  ];
