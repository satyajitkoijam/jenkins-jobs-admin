def jobDslScript = 'pipelines/admin/jobDsl.groovy'
def codeGitRepo  = ['https://github.com/satyajitkoijam/jenkins-repo.git']
def codeGitBranch = ['master']

def scripts = [
    "jobs/*.groovy"
]

pipelineJob('gcp-seedjob') {
    description('')
    logRotator(5, 5)
    parameters {
        choiceParam('gitUrl', codeGitRepo, '')
        choiceParam('gitBranch', codeGitBranch, '')
        choiceParam('dslScript', scripts, '')
    }
    definition {
        cps {
            scripts(readFileFromWorkspace(jobDslScript))
            sandbox()
        }
    }
}
