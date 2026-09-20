package com.jenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDockerDemoApplication.class, args);
    }

    @GetMapping(value = "/", produces = "text/html")
    public String dashboard() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>CloudOps Dashboard</title>
                <meta name="viewport" content="width=device-width, initial-scale=1">

                <style>
                    * {
                        box-sizing: border-box;
                        margin: 0;
                        padding: 0;
                        font-family: Arial, sans-serif;
                    }

                    body {
                        background: #f4f7fb;
                        color: #1f2937;
                    }

                    .header {
                        background: #111827;
                        color: white;
                        padding: 20px 35px;
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                    }

                    .logo {
                        font-size: 24px;
                        font-weight: bold;
                    }

                    .status {
                        color: #22c55e;
                        font-size: 14px;
                    }

                    .layout {
                        display: flex;
                        min-height: calc(100vh - 70px);
                    }

                    .sidebar {
                        width: 220px;
                        background: #1f2937;
                        color: white;
                        padding: 25px 15px;
                    }

                    .sidebar div {
                        padding: 14px;
                        margin-bottom: 8px;
                        border-radius: 8px;
                        cursor: pointer;
                    }

                    .sidebar div:hover {
                        background: #374151;
                    }

                    .content {
                        flex: 1;
                        padding: 35px;
                    }

                    h1 {
                        margin-bottom: 8px;
                    }

                    .subtitle {
                        color: #6b7280;
                        margin-bottom: 30px;
                    }

                    .cards {
                        display: grid;
                        grid-template-columns: repeat(4, 1fr);
                        gap: 20px;
                        margin-bottom: 30px;
                    }

                    .card {
                        background: white;
                        padding: 22px;
                        border-radius: 12px;
                        box-shadow: 0 2px 8px rgba(0,0,0,0.08);
                    }

                    .card-title {
                        color: #6b7280;
                        font-size: 14px;
                        margin-bottom: 12px;
                    }

                    .number {
                        font-size: 30px;
                        font-weight: bold;
                    }

                    .online {
                        color: #16a34a;
                    }

                    .warning {
                        color: #d97706;
                    }

                    .offline {
                        color: #dc2626;
                    }

                    .section {
                        background: white;
                        padding: 25px;
                        border-radius: 12px;
                        margin-bottom: 25px;
                        box-shadow: 0 2px 8px rgba(0,0,0,0.08);
                    }

                    .section h2 {
                        margin-bottom: 20px;
                    }

                    .server {
                        display: flex;
                        justify-content: space-between;
                        padding: 15px 0;
                        border-bottom: 1px solid #e5e7eb;
                    }

                    .server:last-child {
                        border-bottom: none;
                    }

                    .badge {
                        padding: 5px 10px;
                        border-radius: 20px;
                        font-size: 12px;
                        background: #dcfce7;
                        color: #166534;
                    }

                    .warning-badge {
                        background: #fef3c7;
                        color: #92400e;
                    }

                    .progress {
                        height: 8px;
                        background: #e5e7eb;
                        border-radius: 10px;
                        margin-top: 10px;
                    }

                    .progress-bar {
                        height: 100%;
                        width: 72%;
                        background: #2563eb;
                        border-radius: 10px;
                    }

                    .deployment {
                        display: flex;
                        justify-content: space-between;
                        padding: 14px 0;
                        border-bottom: 1px solid #e5e7eb;
                    }

                    @media (max-width: 900px) {
                        .cards {
                            grid-template-columns: repeat(2, 1fr);
                        }

                        .sidebar {
                            display: none;
                        }
                    }
                </style>
            </head>

            <body>

                <div class="header">
                    <div class="logo">☁ CloudOps</div>
                    <div class="status">● System Operational</div>
                </div>

                <div class="layout">

                    <div class="sidebar">
                        <div>📊 Dashboard</div>
                        <div>🖥 Servers</div>
                        <div>🚀 Deployments</div>
                        <div>📈 Monitoring</div>
                        <div>📋 Logs</div>
                        <div>⚙ Settings</div>
                    </div>

                    <div class="content">

                        <h1>Infrastructure Dashboard</h1>
                        <p class="subtitle">
                            Monitor your applications and infrastructure
                        </p>

                        <div class="cards">

                            <div class="card">
                                <div class="card-title">SERVERS ONLINE</div>
                                <div class="number online">12</div>
                            </div>

                            <div class="card">
                                <div class="card-title">WARNINGS</div>
                                <div class="number warning">2</div>
                            </div>

                            <div class="card">
                                <div class="card-title">OFFLINE</div>
                                <div class="number offline">1</div>
                            </div>

                            <div class="card">
                                <div class="card-title">DEPLOYMENTS</div>
                                <div class="number">48</div>
                            </div>

                        </div>

                        <div class="section">

                            <h2>🖥 Server Status</h2>

                            <div class="server">
                                <span>Production Server 01</span>
                                <span class="badge">Online</span>
                            </div>

                            <div class="server">
                                <span>Production Server 02</span>
                                <span class="badge">Online</span>
                            </div>

                            <div class="server">
                                <span>Database Server</span>
                                <span class="badge warning-badge">Warning</span>
                            </div>

                            <div class="server">
                                <span>Backup Server</span>
                                <span class="badge">Online</span>
                            </div>

                        </div>

                        <div class="section">

                            <h2>📈 CPU Usage</h2>

                            <p>Current CPU utilization: <strong>72%</strong></p>

                            <div class="progress">
                                <div class="progress-bar"></div>
                            </div>

                        </div>

                        <div class="section">

                            <h2>🚀 Recent Deployments</h2>

                            <div class="deployment">
                                <span>v1.4.2 — Production</span>
                                <span class="online">✓ Successful</span>
                            </div>

                            <div class="deployment">
                                <span>v1.4.1 — Production</span>
                                <span class="online">✓ Successful</span>
                            </div>

                            <div class="deployment">
                                <span>v1.4.0 — Staging</span>
                                <span class="online">✓ Successful</span>
                            </div>

                        </div>

                    </div>

                </div>

            </body>
            </html>
            """;
    }
}